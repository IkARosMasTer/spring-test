package org.choviwu.movie.config.returnhandler;

import java.lang.reflect.Field;

public class ObjectReturnSelector implements ReturnSelector<Object> {


    @Override
    public boolean supportsFieldType(Class<Object> objectClass, Field field) {
        return   (field.isAnnotationPresent(NullToEmpty.class));
    }

    @Override
    public void match(Object obj, Object object, Field field, String  str) {
        if (field.isAnnotationPresent(NullToEmpty.class)) {
            if(!isObjType(field)){
                return;
            }
            boolean flag = field.getDeclaredAnnotation(NullToEmpty.class).toTrim();
            if (flag) {
                Field[] fields = object.getClass().getDeclaredFields();
                for (Field field1 : fields) {
                    NullToEmptyUtil.getInstance().getField(object, field1);
                }
            }
        }
    }
    private boolean isObjType(Field field){
        NullToEmpty empty = field.getDeclaredAnnotation(NullToEmpty.class);
        //是否包装类型 默认false
        boolean isObj = empty.isObj();
        return isObj;
    }
}
