package org.choviwu.movie.config.returnhandler;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author ChoviWu 2019年4月19日10:21:00
 */
@Slf4j
public class ReturnSelectorFactory<T> {

    private T result;

    private Object object;
    private Field field;
    private String text;
    //field is ignored
    private boolean flag;
    private Class clazz;

    public ReturnSelectorFactory(Object obj, T t, Field field, String text) {
        this.field = field;
        this.object = obj;
        this.result = t;
        this.text = text;
        this.flag = field.isAnnotationPresent(Ignored.class);
        this.clazz = field.getType();
    }

    public void match() throws Exception {
        log.info(">>>>>>>>>>> flag value : {}",flag);
        //ignored
        if(flag){
            return;
        }

        //match string
        ReturnSelector returnSelector = null;
        if (clazz == String.class) {
            returnSelector = new StringReturnSelector();
        }
        //match boolean
        if (clazz == Boolean.class
                || "boolean".equals(field.getType().toString())) {
            returnSelector = new BooleanReturnSelector();
        }
        //match double
        if (clazz == Double.class
                || "double".equals(field.getType().toString())) {
            returnSelector = new DoubleReturnSelector();
        }
        //match integer
        if (clazz == Integer.class
                || "int".equals(field.getType().toString())) {
            if (Objects.isNull(result)) {
                field.set(object, Integer.valueOf(text));
            }
            return;
        }
        //match long
        if (clazz == Long.class
                || "long".equals(field.getType().toString())) {
            if (Objects.isNull(result)) {
                field.set(object, Long.valueOf(text));
            }
            return;
        }
        //match date
        if (clazz == Date.class
                || "date".equals(field.getType().toString())) {
            returnSelector = new DateReturnSelector();
        }
        //match map
        if (clazz == Map.class) {
            returnSelector = new MapReturnSelector();
        }
        //match list
        if (clazz == List.class || clazz == ArrayList.class
                || clazz == LinkedList.class) {
            returnSelector = new ListReturnSelector();
        }
        //包装对象
        if (returnSelector == null) {
            if (!field.isAnnotationPresent(NullToEmpty.class)) {
                return;
            }
            if(!isObjType(field)){
                return;
            }
            returnSelector = new ObjectReturnSelector();
        }
        returnSelector.match(this.object, this.result, this.field, this.text);
    }

    private boolean isObjType(Field field){
        NullToEmpty empty = field.getDeclaredAnnotation(NullToEmpty.class);
        //是否包装类型 默认false
        boolean isObj = empty.isObj();
        return isObj;
    }
}
