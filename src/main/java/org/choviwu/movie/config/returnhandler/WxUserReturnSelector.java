package org.choviwu.movie.config.returnhandler;

import org.choviwu.movie.model.WxUser;

import java.lang.reflect.Field;
import java.util.Objects;

public class WxUserReturnSelector implements ReturnSelector<WxUser> {
    @Override
    public boolean supportsFieldType(Class<WxUser> wxUserClass, Field field) {
        return wxUserClass == WxUser.class;
    }

    @Override
    public void match(Object obj, WxUser wxUser, Field field, String str) {
//        WxUser current = wxUser;
        if(wxUser!=null){
            for (Field f : wxUser.getClass().getDeclaredFields()){
                NullToEmptyUtil.getInstance().getField(wxUser,f);
            }
        }else{
            wxUser = new WxUser();
            try {
                field.set(obj,wxUser);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
