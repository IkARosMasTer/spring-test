package org.choviwu.movie.config.returnhandler;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChoviWu
 */
@Slf4j
public class NullToEmptyUtil {

    private static final NullToEmptyUtil empty = new NullToEmptyUtil();

    private   ReturnSelectorAdapter returnSelectorAdapter;

    public static NullToEmptyUtil getInstance() {
        return empty;
    }

    public void setReturnSelectorAdapter(ReturnSelectorAdapter returnSelectorAdapter) {
        this.returnSelectorAdapter = returnSelectorAdapter;
    }

    public ReturnSelectorAdapter getReturnSelectorAdapter() {
        return returnSelectorAdapter;
    }

    public void getField(Object object, Field field) {
        //value
        NullToEmpty returnNull = field.getDeclaredAnnotation(NullToEmpty.class);
        StringBuilder text = new StringBuilder();
        if (returnNull != null) {
            text.append(returnNull.text());
        }
        field.setAccessible(true);
        try {
            Object result = field.get(object);
            returnSelectorAdapter.match(object, result, field, text.toString());
        }catch (Exception e){
            log.error("get field exception :{} ,please checked field {}",e,field);
        }
    }


    public List<Field> getSuperFields(Class<?> obj, List<Field> list) {

        if (obj == Object.class) {
            return list;
        }
        Field[] fields = obj.getDeclaredFields();
        Arrays.asList(fields).forEach(list::add);
        Class clss = obj.getSuperclass();
        return getSuperFields(clss, list);
    }

}
