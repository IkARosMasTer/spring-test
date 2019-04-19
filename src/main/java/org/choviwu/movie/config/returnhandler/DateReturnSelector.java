package org.choviwu.movie.config.returnhandler;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;

public class DateReturnSelector implements ReturnSelector<Date> {


    @Override
    public boolean supportsFieldType(Class<Date> dateClass, Field field) {
        return (dateClass == Date.class
                || "date".equals(field.getType().toString()));
    }

    @Override
    public void match(Object obj, Date date, Field field, String  str)  {
        if (Objects.isNull(date)) {
//            field.set(obj, DateUtils.getDate(str[0]));
        }
    }
}
