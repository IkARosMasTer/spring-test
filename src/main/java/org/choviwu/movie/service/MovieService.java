package org.choviwu.movie.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.choviwu.movie.base.ApiResponse;
import org.choviwu.movie.mapper.MovieMapper;
import org.choviwu.movie.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ChoviWu on 2018/06/23
 * Description:
 */
@Service
public class MovieService {

    private final MovieMapper movieMapper;

    @Autowired
    MovieService(MovieMapper movieMapper){
        this.movieMapper = movieMapper;
    }

    /**
     * 随机返回六条
     * @param type  类型
     * @return
     */
    public Object getListByType(String type){
//        PageHelper.startPage(0,5);
//        List<Movie> list = movieMapper.getMovieListByType(type);
        List<MovieVo> movieVos = Lists.newArrayList();
//        list.forEach(c->{
//            MovieVo movieVo = new MovieVo();
//            movieVo.setMovie(c);
//            WxUser user = new WxUser();
//            user.setOpenid("1232131312312");
//            user.setAddtime(new Date());
//            user.setAddip(null);
//            movieVo.setWxUser(user);
//            movieVos.add(movieVo);
//        });

        return new PageInfo(movieVos);
    }
    /**
     * 随机返回六条
     * @param type  类型
     * @return
     */
    public Object getListByType1(String type){
        PageHelper.startPage(0,5);
        List<Movie> list = movieMapper.getMovieListByType(type);
        return ApiResponse.builder().code(1).data(list).msg("success").build();
    } /**
     * 随机返回六条
     * @param type  类型
     * @return
     */
    public Object getListByType2(String type){
//        PageHelper.startPage(0,5);
        List<Movie> list = movieMapper.getMovieListByType(type);
        List<MovieVo> movieVos = Lists.newArrayList();
        list.forEach(c->{
            MovieVo movieVo = new MovieVo();
            UserInputVo userInput = new UserInputVo();
            userInput.setAddip(null);
            WxUser user = new WxUser();
            user.setAddtime(new Date());
            userInput.setWxUser(user);
            userInput.setMovie(c);
            movieVo.setUserInputVo(userInput);
            movieVos.add(movieVo);
        });

        return ApiResponse.builder().code(1).data(movieVos).msg("success").build();
    } /**
     * 随机返回六条
     * @param type  类型
     * @return
     */
    public Object getListByType4(String type){
//        PageHelper.startPage(0,5);
//        List<Movie> list = movieMapper.getMovieListByType(type);
//        List<MovieVo> movieVos = Lists.newArrayList();
//        list.forEach(c->{
//            MovieVo movieVo = new MovieVo();
//            movieVo.setMovie(c);
//            WxUser user = new WxUser();
//            user.setOpenid("1232131312312");
//            user.setAddtime(new Date());
//            user.setAddip(null);
//            movieVo.setWxUser(user);
//            movieVos.add(movieVo);
//        });
//        Map map = Maps.newHashMap();
//        map.put("maps",movieVos);
//        return movieVos;
        return null;
    }
}
