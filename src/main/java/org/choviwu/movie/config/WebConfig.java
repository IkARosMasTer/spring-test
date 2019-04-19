package org.choviwu.movie.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.choviwu.movie.config.returnhandler.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport implements InitializingBean{


    @Autowired
    RequestMappingHandlerAdapter requestMappingHandlerAdapter;


    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ValidatorMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Bean("jackson2HttpMessageConverter")
    public HttpMessageConverter jackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDefaultVisibility(JsonAutoDetect.Value.defaultVisibility());
        objectMapper.setDateFormat(DateFormat.getDateInstance());
        converter.setObjectMapper(objectMapper);
        return converter;
    }
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jackson2HttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Override
    protected ExceptionHandlerExceptionResolver createExceptionHandlerExceptionResolver() {
        return super.createExceptionHandlerExceptionResolver();
    }
    /**
     * 防止@EnableMvc把默认的静态资源路径覆盖了，手动设置的方式
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        NullToEmptyUtil.getInstance().setReturnSelectorAdapter(selectorAdapter());
        List<HandlerMethodReturnValueHandler> unmodifiableList = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> list = new ArrayList<>(unmodifiableList.size());
        for (HandlerMethodReturnValueHandler returnValueHandler : unmodifiableList) {
            if (returnValueHandler instanceof RequestResponseBodyMethodProcessor) {
                //将RequestResponseBodyMethodProcessor 实际返回值替换为自定义的，实际执行为RequestResponseBodyMethodProcessor
                //重要
                HandlerMethodReturnValueHandler handler = new EmptyFieldReturnValueHandler(returnValueHandler);
                list.add(handler);
            }
            else {
                list.add(returnValueHandler);
            }
        }
        requestMappingHandlerAdapter.setReturnValueHandlers(list);
    }

    @Bean
    public ReturnSelectorAdapter selectorAdapter(){
        ReturnSelectorAdapter adapter = new ReturnSelectorAdapter();
        List<ReturnSelector> list = Lists.newArrayList();
        list.add(new IntegerReturnSelector());
        list.add(new DoubleReturnSelector());
        list.add(new LongReturnSelector());
        list.add(new DateReturnSelector());
        list.add(new StringReturnSelector());
        list.add(new ObjectReturnSelector());
//        list.add(new IntegerReturnSelector());
        adapter.setReturnSelectors(list);
        return adapter;
    }
}
