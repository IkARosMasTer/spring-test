package org.choviwu.movie.controller;


import lombok.extern.slf4j.Slf4j;
import org.choviwu.movie.model.Customer;
import org.choviwu.movie.service.WechatService;
import org.choviwu.movie.util.WxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/wechat")
public class WechatController {


    private final WechatService wechatService;


    @Autowired
    WechatController(WechatService wechatService) {
        this.wechatService = wechatService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/xml;charset=UTF-8")
    @ResponseBody
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("============================================================");
        // 拼接字符串
        // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        log.info("输入 : " + signature + "  " + timestamp + "   " + nonce);
        // 响应消息
        if (WxUtils.checkSignature(signature, timestamp, nonce)) {
            log.info("验证成功。。。");
            response.getOutputStream().println(echostr);
        }

    }

    //"application/xml;charset=UTF-8"
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public void post(HttpServletRequest request, HttpServletResponse response) {
        try {
            log.info("=============================comming===============================");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (Exception e) {

        }
        String respMessage = wechatService.processRequest(request);
        // 响应消息
        log.info("验证成功。。。返回的数据： " + respMessage);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(respMessage);
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            out.print(respMessage);
            out.close();
        }
    }

    @ResponseBody
    @RequestMapping("/src/main/test")
    public Object test(HttpServletRequest request) {
//	 	String logo = request.getServletContext().getRealPath("/WEB-INF/upload/logo.jpg");
//		String fileUrl = request.getServletContext().getRealPath("/WEB-INF/upload/"+ UUID.randomUUID().toString()+".jpg");
//		Customer customer = new Customer();
//		customer.setScore("100");
//		customer.setName("fdsa");
//		customer.setKaoshi_date("123123");
//		customer.setSchool("asdasd");
//		ImageUtils.graphicsGeneration("12423432","1","picture",
//				logo,new Customer(),
//				fileUrl );
//	 	return logo;
        return null;
    }

    @ResponseBody
    @RequestMapping("test")
    public Object test2(HttpServletRequest request) {
        return wechatService.processRequest(request);
    }
}
