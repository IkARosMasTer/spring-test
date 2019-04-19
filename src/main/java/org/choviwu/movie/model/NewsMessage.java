package org.choviwu.movie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choviwu.movie.base.BaseModel;
import org.choviwu.movie.util.WechatMessageUtil;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsMessage extends BaseModel implements Serializable{

    private Integer ArticleCount;

    private List<Item> Articles;


    /**
     * 封装图文电影
     * @param po
     * @return
     */
    public NewsMessage setMovie(MoviePo po) {
        this.setArticleCount(po.getItems().size());
        this.setArticles(po.getItems());
        this.setMsgType(WechatMessageUtil.MESSAGE_NEWS);
        this.setToUserName(po.getToUserName());
        this.setFromUserName(po.getFromUserName());
        this.setCreateTime(System.currentTimeMillis());
        return this;
    }
}
