package org.choviwu.movie.model;

import org.choviwu.movie.base.BaseModel;

import java.io.Serializable;

/**
 * 用户发送消息文本类
 */
public class TextMessage extends BaseModel implements Serializable{

    private String Content;



    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
