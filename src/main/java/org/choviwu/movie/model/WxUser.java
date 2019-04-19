package org.choviwu.movie.model;

import org.choviwu.movie.config.returnhandler.DateReturnSelector;
import org.choviwu.movie.config.returnhandler.IntegerReturnSelector;
import org.choviwu.movie.config.returnhandler.NullToEmpty;
import org.choviwu.movie.config.returnhandler.StringReturnSelector;

import java.util.Date;

public class WxUser {
    @NullToEmpty(text = "1",clazz = IntegerReturnSelector.class)
    private Integer id;
    @NullToEmpty(text = "暂无",clazz = StringReturnSelector.class)
    private String openid;
    @NullToEmpty(text = "yyyy-MM-dd",clazz = DateReturnSelector.class)
    private Date addtime;
    @NullToEmpty(text = "暂无",clazz = StringReturnSelector.class)
    private String addip;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getAddip() {
        return addip;
    }

    public void setAddip(String addip) {
        this.addip = addip;
    }
}