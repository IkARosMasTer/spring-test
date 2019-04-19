package org.choviwu.movie.config.returnhandler;

import java.lang.reflect.Field;
import java.util.Objects;

public class StringReturnSelector implements ReturnSelector<String> {


    @Override
    public boolean supportsFieldType(Class<String> stringClass, Field field) {
        return (stringClass == String.class);
    }

    @Override
    public void match(Object obj, String s, Field field,String str) {
        if(Objects.isNull(s)){
            try {
                field.set(obj,str);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
