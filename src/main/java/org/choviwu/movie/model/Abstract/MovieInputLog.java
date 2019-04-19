package org.choviwu.movie.model.Abstract;


import org.choviwu.movie.Enums.LogRemark;
import org.choviwu.movie.util.IpUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ChoviWu on 2017/12/24
 * Description :用户搜索电影 日志记录
 */
public class MovieInputLog extends Model implements Serializable {

    public MovieInputLog(){
        input.setAddip("8.8.8.8");
        input.setRemark(LogRemark.Movie.getKey());
    }

    @Override
    public void deal(String fromUserName, String content, String response) {
        insertLog();
        input.setContent(content);
        input.setOpenid(fromUserName);
        input.setResponse(response);
    }

    @Override
    public void insertLog() {
        input.setAddtime(new Date());
    }
}
