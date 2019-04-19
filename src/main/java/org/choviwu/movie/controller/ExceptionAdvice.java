package org.choviwu.movie.controller;

import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestControllerAdvice
public class ExceptionAdvice  {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Object exception(Exception ex, HttpServletRequest request){
        Map map = Maps.newHashMap();
        map.put("msg","fail");
        map.put("code",-1);
        map.put("data",ex.getMessage());
        return map;
    }
}
