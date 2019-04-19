package org.choviwu.movie.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.choviwu.movie.mapper.ConfigMapper;
import org.choviwu.movie.mapper.WxUserMapper;
import org.choviwu.movie.model.Abstract.*;
import org.choviwu.movie.model.*;
import org.choviwu.movie.service.handler.UserInputHandler;
import org.choviwu.movie.util.IpUtils;
import org.choviwu.movie.util.JsonUtils;
import org.choviwu.movie.util.MessageUtil;
import org.choviwu.movie.util.WechatMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ChoviWu
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Service
@Slf4j
public class WechatService {


    private final WxUserMapper userMapper;
    private final ConfigMapper configMapper;
    private final UserInputHandler inputHandler;
    private final WeatherService weatherService;
    private final CrawlService crawlService;
    private final MovieService movieService;

    @Autowired
    WechatService(WxUserMapper userMapper, ConfigMapper configMapper,
                  UserInputHandler inputHandler, MovieService movieService,
                  WeatherService weatherService, CrawlService crawlService) {
        this.crawlService = crawlService;
        this.userMapper = userMapper;
        this.configMapper = configMapper;
        this.weatherService = weatherService;
        this.inputHandler = inputHandler;
        this.movieService = movieService;
    }

    public String processRequest(HttpServletRequest request) {
//        if(request.getContentLength()<0){
//            return weatherService.getWeather();
//        }
        String respMessage = null;
        Map<String, String> requestMap = MessageUtil.parseXml(request);
        //用户
        String fromUserName = requestMap.get("FromUserName");
        log.info("前方来了一个用户 ：" + fromUserName);
        // 公众帐号
        String toUserName = requestMap.get("ToUserName");
        // 消息类型
        String msgType = requestMap.get("MsgType");
        log.info("发送的类型是 ：" + msgType);

        //发送的消息内容
        String content = requestMap.get("Content");
        log.info("发送的内容是 ：" + content);
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        Long time = System.currentTimeMillis();
        textMessage.setCreateTime(time);
        textMessage.setMsgType(WechatMessageUtil.MESSAGE_TEXT);
        try {
            //事件推送提醒
            if (msgType.equals(WechatMessageUtil.MESSAGE_EVENT)) {
                String eventType = requestMap.get("Event");
                log.info("I am comming Event ...");
                //关注订阅发送消息
                if (eventType.equals(WechatMessageUtil.MESSAGE_EVENT_SUBSCRIBE)) {
                    log.info("I am comming MESSAGE_EVENT_SUBSCRIBE ...");
                    //插入用户记录
                    insertUser(textMessage, request);
                    String subscribe = configMapper.getDBValueByParam("subscribe");
                    //虚拟计数方式
                    Integer count = userMapper.count() + Integer.parseInt(configMapper.
                            getDBValueByParam("base_count"));
                    textMessage.setContent(subscribe + count + "个宝宝关注我哦！");
                    Model model = new SubscribeLog(request);
                    model.deal(fromUserName, content, textMessage.getContent());
                    inputHandler.deal(model);
                    return MessageUtil.textMessageToXml(textMessage);

                } else if (eventType.equals(WechatMessageUtil.MESSAGE_EVENT_UNSUBSCRIBE)) {
                    //取消关注
                    textMessage.setContent(textMessage.getToUserName() + "取消关注");
                    Model model = new UnSubscirbeLog(request);
                    model.deal(fromUserName, "", textMessage.getContent());
                    inputHandler.deal(model);
                    log.info("==================================" + textMessage.getToUserName() + "取消关注");
                }
            } else {
                // 文本消息
                if (msgType.equals(WechatMessageUtil.MESSAGE_TEXT)) {
                    //骂人的直接返回
                    String enheng = configMapper.getDBValueByParam("input_enheng_aha");
                    if (enheng.contains(content)) {
                        textMessage.setContent(configMapper.getDBValueByParam("please_originazed_language"));
                        Model model = new UserInputLog(request);
                        model.deal(fromUserName, content, content);
                        inputHandler.deal(model);
                        return MessageUtil.textMessageToXml(textMessage);
                    }

                    log.info("开始爬 ...");
                    List<Movie> list = crawlService.crawl(content);
                    if (list != null && list.size() > 0) {
                        for (Movie movie : list) {
                            movie.setMovieName(movie.getDescription());
                        }
                    }
                    //若空  则去页面爬取链接
                    log.info("爬完之后... ");
                    return sendMessage(textMessage, list, content);
                }
                String others = "请输入正确的文字或电影名称（支持模糊匹配）";
                textMessage.setContent(others);
                Model model = new OtherLog(request);
                model.deal(fromUserName, content, textMessage.getContent());
                inputHandler.deal(model);
            }
            return MessageUtil.textMessageToXml(textMessage);
        } catch (Exception exception) {
            log.info(exception.getMessage());
            textMessage.setContent("没有找到资源。");
            Model model = new OtherLog(request);
            model.deal(fromUserName, content, textMessage.getContent());
            inputHandler.deal(model);
            return MessageUtil.textMessageToXml(textMessage);
        }
    }


    /**
     * 发送包装好的消息
     * @param textMessage
     * @param list
     * @param content
     * @return
     */
    private String sendMessage(TextMessage textMessage,
                               List<Movie> list, String content) {
        if (list.size() > 0) {
            MoviePo moviePo = new MoviePo();
            List<Item> items = Lists.newArrayList();

            //记录日志
            log.info("发送方： " + textMessage.getFromUserName() + "接收方：" + textMessage.getToUserName());
            //用户搜索电影日志收集
            Model model = new MovieInputLog();
            model.deal(textMessage.getToUserName(), content, JsonUtils.toJson(moviePo));
            inputHandler.deal(model);

            //随机装配一个
            Integer random = Double.valueOf(Math.random()*list.size()).intValue();
            StringBuilder sb = new StringBuilder();
            log.info("随机数： " + random);
            if(random%2==0){
                list.stream().forEach(movie -> {

                    sb.append("电影名："+movie.getMovieName().substring(0,movie.getMovieName().length()>20 ? 20 : movie.getMovieName().length()-1))
                            .append("  观影链接： "+movie.getUrl()+"\n");
                });
                textMessage.setContent(sb.toString()
                        +"\n"+"如果网站已经被屏蔽，请将链接粘贴到浏览器上观看,感谢您的支持！");
                return MessageUtil.textMessageToXml(textMessage);
            }
            //默认第一条
            Movie movie = list.get(0);
            try {
                movie = list.get(random);
                log.info("电影的来源： {}",movie.getReferer());
            }catch (Exception e){

            }
            items.add(new Item(movie.getMovieName(),
                    movie.getDescription(), movie.getMovieLogo(), movie.getUrl()));
//            list.stream().forEach(movie ->{
//
//                    items.add(new Item(movie.getMovieName(),
//                            movie.getDescription(), movie.getMovieLogo(), movie.getUrl()))
//            });
            moviePo.setItems(items);
            moviePo.setFromUserName(textMessage.getFromUserName());
            moviePo.setToUserName(textMessage.getToUserName());

            return MessageUtil.newsMessageToXml(new NewsMessage().setMovie(moviePo));
        } else {
            //未找到该资源
            textMessage.setContent("未找到该资源");
            Model model = new MovieInputLog();
            model.deal(textMessage.getToUserName(), content, textMessage.getContent());
            inputHandler.deal(model);
            log.info(" ==============  " + textMessage.getContent() + "=======================");
            return MessageUtil.textMessageToXml(textMessage);
        }
    }

    /**
     * 插入用户
     * @param textMessage
     * @param request
     */
    private void insertUser(TextMessage textMessage, HttpServletRequest request) {
        WxUser user = userMapper.selectByOpenId(textMessage.getToUserName());
        if (StringUtils.isEmpty(user)) {
            WxUser wxUser = new WxUser();
            wxUser.setOpenid(textMessage.getToUserName());
            wxUser.setAddtime(new Date());
            wxUser.setAddip(IpUtils.getRemoteIp(request));
            userMapper.insert(wxUser);
        } else {
            user.setAddtime(new Date());
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    public static void main(String[] args) {
        List list = Lists.newArrayList();
        list.add("abc");
        list.add("bcc");
        list.add("baa");
        for (int i = 0;i<=1000;i++) {
            int random = Double.valueOf(Math.random() * list.size()).intValue();
            System.out.println(random);
        }
    }

}
