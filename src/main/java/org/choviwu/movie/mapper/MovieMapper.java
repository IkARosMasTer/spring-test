package org.choviwu.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.choviwu.movie.model.Movie;
import org.choviwu.movie.model.MovieExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MovieMapper extends Mapper<Movie>{

    List<Movie> getMovieListByName(@Param("name") String name,@Param("referer")String referer);

    List<Movie> getMovieListByReferer(@Param("referer")String referer);

    List<Movie> getMovieListByDesc(@Param("description") String description,@Param("referer")String referer);

    List<Movie> getMovieListByType(@Param("type") String type);
 }