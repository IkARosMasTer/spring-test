package org.choviwu.movie.config.returnhandler;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MapReturnSelector implements ReturnSelector<Map<String, Object>> {


    @Override
    public boolean supportsFieldType(Class<Map<String, Object>> mapClass, Field field) {
        return false;
    }

    @Override
    public void match(Object obj, Map<String, Object> map, Field field, String str) {
        map.forEach((k, v) -> {
            if (Objects.nonNull(v)) {
                List<Field> subFields = NullToEmptyUtil.getInstance().getSuperFields(v.getClass(), Lists.newArrayList());
                subFields.forEach(subField -> {
                    try {
                        NullToEmptyUtil.getInstance().getField(map, subField);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }
}
