package org.choviwu.movie.service;

import lombok.extern.slf4j.Slf4j;
import org.choviwu.movie.base.Constant;
import org.choviwu.movie.mapper.ConfigMapper;
import org.choviwu.movie.mapper.WxUserMapper;
import org.choviwu.movie.model.Abstract.Model;
import org.choviwu.movie.model.Abstract.PushWeatherLog;
import org.choviwu.movie.model.Abstract.SubscribeLog;
import org.choviwu.movie.model.TextMessage;
import org.choviwu.movie.model.WxUser;
import org.choviwu.movie.model.weather.Weather;
import org.choviwu.movie.service.handler.UserInputHandler;
import org.choviwu.movie.util.HttpUtils;
import org.choviwu.movie.util.JsonUtils;
import org.choviwu.movie.util.MessageUtil;
import org.choviwu.movie.util.WechatMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class WeatherService {

    private final WxUserMapper userMapper;
    private final ConfigMapper configMapper;
    private final UserInputHandler inputHandler;

    @Autowired
    WeatherService(WxUserMapper userMapper,ConfigMapper configMapper,
                   UserInputHandler inputHandler){
        this.userMapper = userMapper;
        this.configMapper = configMapper;
        this.inputHandler = inputHandler;
    }

    public  String getWeather(){
//        List<WxUser> list = userMapper.getList();

//        String fromUserName = "gh_7d8f47791526";
        String fromUserName = configMapper.getDBValueByParam("app_origin_id");
        String toUserName = "o6t23w2DOPFZbaMqizkI4bOvHhXA";
//        if(list!=null && list.size()>0) {
//            for (WxUser user : list) {
//                try {
//                    String toUserName = user.getOpenid();
                    Map map = new HashMap();
                    map.put("id", "西安市");
                    String result = HttpUtils.URLGet("http://api.help.bj.cn/apis/alarm", map, Constant.UTF8);
                    map.clear();
                    Weather weather = JsonUtils.json2Object(result, Weather.class);
                    String content = weather.toString();
                    TextMessage textMessage = new TextMessage();
                    textMessage.setToUserName(toUserName);
                    textMessage.setFromUserName(fromUserName);
                    Long time = new Date().getTime();
                    textMessage.setCreateTime(time);
                    textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
                    textMessage.setContent(content);
                    Model model = new PushWeatherLog(null);
                    model.deal(fromUserName, content, textMessage.getContent().toString());
                    inputHandler.deal(model);

                    return MessageUtil.textMessageToXml(textMessage);

//                }catch (Exception e){

//                }
//            }
//        }
//        return null;
    }

    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService(null,null,null);
        weatherService.getWeather();
    }
}
