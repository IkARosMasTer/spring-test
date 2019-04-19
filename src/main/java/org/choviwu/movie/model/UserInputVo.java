package org.choviwu.movie.model;

import lombok.Data;
import org.choviwu.movie.config.returnhandler.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class UserInputVo {
    @NullToEmpty(text = "12213",clazz = IntegerReturnSelector.class)
    private Integer id;
    @NullToEmpty(text = "我是内容",clazz = StringReturnSelector.class)
    private String content;
    @NullToEmpty(text = "我是响应",clazz = StringReturnSelector.class)
    private String response;
    @NullToEmpty(text = "openId",clazz = StringReturnSelector.class)
    private String openid;
    @NullToEmpty(text = "标记",clazz = StringReturnSelector.class)
    private String remark;
    @NullToEmpty(text = "yyyyMMdd",clazz = DateReturnSelector.class)
    private Date addtime;

    private String addip;

    @NullToEmpty(isObj = true,clazz = WxUserReturnSelector.class)
    private WxUser wxUser;
    @NullToEmpty(isObj = true)
    private Movie movie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}