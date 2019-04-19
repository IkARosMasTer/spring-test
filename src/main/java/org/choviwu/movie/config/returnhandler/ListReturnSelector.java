package org.choviwu.movie.config.returnhandler;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class ListReturnSelector implements ReturnSelector<List> {

    @Override
    public boolean supportsFieldType(Class listClass, Field field) {
        return (listClass == List.class || listClass == ArrayList.class
                || listClass == LinkedList.class);
    }

    @Override
    public void match(Object obj, List list, Field field, String str) {
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(c -> {
                List<Field> subFields = NullToEmptyUtil.getInstance().getSuperFields(c.getClass(), Lists.newArrayList());
                subFields.forEach(subField -> {
                    NullToEmptyUtil.getInstance().getField(c, subField);
                });
            });
        } else {
            list = Collections.emptyList();
            try {
                field.set(obj, list);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
