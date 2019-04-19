package org.choviwu.movie.config.returnhandler;

import java.lang.reflect.Field;
import java.util.Objects;

public class DoubleReturnSelector implements ReturnSelector<Double> {


    @Override
    public boolean supportsFieldType(Class<Double> doubleClass, Field field) {
        return (doubleClass == Double.class
                || "double".equals(field.getType().toString()));
    }

    @Override
    public void match(Object obj, Double flag, Field field, String  str)  {
        if (Objects.isNull(flag)) {
            try {
                field.set(obj, Double.parseDouble(str.toString()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
