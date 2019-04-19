package org.choviwu.movie.controller;

import org.choviwu.movie.annotation.Response;
import org.choviwu.movie.annotation.Validator;
import org.choviwu.movie.annotation.ValidatorBody;
import org.choviwu.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Response
    @Validator
    @ResponseBody
    @RequestMapping(value = "index")
    public Object index( @Validator String name,  @Validator String halo){
        return name + halo;
    }
    @Autowired
    MovieService movieService;

    @ResponseBody
    @RequestMapping(value = "abc")
    public Object abc(){
        return movieService.getListByType("");
//        return name + halo;
    }
    @ResponseBody
    @RequestMapping(value = "abcd")
    public Object abcd(){
        return movieService.getListByType1("");
//        return name + halo;
    }
    @ResponseBody
    @RequestMapping(value = "abcde")
    public Object abcde(){
        return movieService.getListByType2("");
//        return name + halo;
    }
    @ResponseBody
    @RequestMapping(value = "abcdef")
    public Object abcdef(){
        return movieService.getListByType4("");
//        return name + halo;
    }


    @ResponseBody
    @RequestMapping(value = "body")
    public Object index(@ValidatorBody @RequestBody String name){
        return name ;
    }
}
