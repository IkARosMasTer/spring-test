package org.choviwu.movie.config.returnhandler;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
@Component
public class ReturnSelectorAdapter {

    private List<ReturnSelector> returnSelectors;

    public ReturnSelectorAdapter(ReturnSelector... returnSelector){
        returnSelectors.addAll(Arrays.asList(returnSelector));
    }
    public ReturnSelectorAdapter( ){
    }

    public void setReturnSelectors(List<ReturnSelector> returnSelectors) {
        this.returnSelectors = returnSelectors;
    }

    public List<ReturnSelector> getReturnSelectors() {
        return returnSelectors;
    }


    public void match(Object obj, Object result, Field field, String str) {
        //ignored filter
        if (field.isAnnotationPresent(Ignored.class)) {
            return;
        }
        Class<? extends ReturnSelector> clazz = getReturnSelector(field);
        if (clazz!=null && clazz != ObjectReturnSelector.class) {
            try {
                ReturnSelector returnSelector = null;
                returnSelector = clazz.getConstructor(null).newInstance();
                returnSelector.match(obj, result, field, str);
                return;
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (ReturnSelector returnSelector : getReturnSelectors()){
            if(returnSelector.supportsFieldType(field.getType(),field)){
                //adapter
                returnSelector.match(obj,result,field,str);
                break;
            }
        }
    }

    private Class<? extends ReturnSelector> getReturnSelector(Field field){
        if(field.isAnnotationPresent(NullToEmpty.class)){
            NullToEmpty empty = field.getDeclaredAnnotation(NullToEmpty.class);
            return empty.clazz();
        }
        return null;
    }
}
