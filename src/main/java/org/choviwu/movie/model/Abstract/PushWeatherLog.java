package org.choviwu.movie.model.Abstract;

import org.choviwu.movie.Enums.LogRemark;
import org.choviwu.movie.util.IpUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;

public class PushWeatherLog extends Model implements Serializable {


    public PushWeatherLog(HttpServletRequest request){
        input.setAddip("0.0.0.0");
        input.setRemark(LogRemark.WeatherPush.getKey());
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
