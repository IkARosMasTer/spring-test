package org.choviwu.movie.config.returnhandler;

import java.lang.reflect.Field;
import java.util.Objects;

public interface ReturnSelector<T> {

    boolean supportsFieldType(Class<T> tClass, Field field);

    default void match(Object obj, T t, Field field, String str){
        if(Objects.isNull(t)){
            try {
                field.set(obj,str);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
