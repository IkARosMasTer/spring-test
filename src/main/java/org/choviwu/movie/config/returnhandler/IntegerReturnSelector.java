package org.choviwu.movie.config.returnhandler;

import java.lang.reflect.Field;
import java.util.Objects;

public class IntegerReturnSelector implements ReturnSelector<Integer> {


    @Override
    public boolean supportsFieldType(Class<Integer> integerClass, Field field) {
        return (integerClass==Integer.class || "int".equals(field.getName().toString()));
    }

    @Override
    public void match(Object obj, Integer s, Field field,String  str)  {
        if(Objects.isNull(s)){
            try {
                field.set(obj,Integer.parseInt(str));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
