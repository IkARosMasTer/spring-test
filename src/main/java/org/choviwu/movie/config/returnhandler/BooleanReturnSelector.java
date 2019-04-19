package org.choviwu.movie.config.returnhandler;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;
@Component
public class BooleanReturnSelector implements ReturnSelector<Boolean> {


    @Override
    public boolean supportsFieldType(Class<Boolean> booleanClass,Field field) {
        return (booleanClass == Boolean.class
                || "boolean".equals(field.getType().toString()));
    }

    @Override
    public void match(Object obj, Boolean flag, Field field, String  str)  {
        if (Objects.isNull(flag)) {
            try {
                field.set(obj, Boolean.parseBoolean(str));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
