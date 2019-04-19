package org.choviwu.movie.config.returnhandler;

import java.lang.reflect.Field;
import java.util.Objects;

public class LongReturnSelector implements ReturnSelector<Long> {


    @Override
    public boolean supportsFieldType(Class<Long> longClass, Field field) {
        return false;
    }

    @Override
    public void match(Object obj, Long s, Field field,String  str)  {
        if(Objects.isNull(s)){
            try {
                field.set(obj,Long.parseLong(str));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
