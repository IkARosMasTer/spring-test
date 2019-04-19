package org.choviwu.movie.model.Abstract ;

import org.choviwu.movie.Enums.LogRemark;
import org.choviwu.movie.util.IpUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户搜索关键字 日志记录
 */
public class UserInputLog extends Model implements Serializable {

    public UserInputLog(HttpServletRequest request){
        input.setRemark(LogRemark.Call.getKey());
        input.setAddip(IpUtils.getRemoteIp(request));
    }

    public void deal(String fromUserName, String content,String response) {

        insertLog();
        input.setContent(content);
        input.setOpenid(fromUserName);
        input.setResponse(response);

    }

    @Override
    public void insertLog() {
        //初始化参数
        input.setAddtime(new Date());

    }
}
