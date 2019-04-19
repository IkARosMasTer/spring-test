package org.choviwu.movie.config;

import org.choviwu.movie.annotation.ValidatorBody;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@ControllerAdvice(basePackages = "org.choviwu.movie")
public class RequestBodyAdvise implements RequestBodyAdvice {


    @Override
    public boolean supports(MethodParameter methodParameter,
                            Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasParameterAnnotation(ValidatorBody.class);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage,
                                           MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage,
                                MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage,
                                  MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}
