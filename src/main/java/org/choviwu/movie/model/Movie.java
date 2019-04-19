package org.choviwu.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choviwu.movie.annotation.ReturnNull;
import org.choviwu.movie.config.returnhandler.NullToEmpty;
import org.choviwu.movie.util.DateUtils;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Integer id;

    private String movieName;

    private String movieLogo;

    private String movieUpdateTime;

    private String actorList;

    private String type;
    private String referer;

    @NullToEmpty(text = "暂无")
    private String url;

    @NullToEmpty(text = "yyyy-MM-dd",isObj = true)
    private Date addtime;

    @NullToEmpty(text = "暂无")
    private String description;


    public Movie(String movieName, String movieLogo, String actorList, String type, String url, String description) {
        this.movieName = movieName;
        this.movieLogo = movieLogo;
        this.actorList = actorList;
        this.type = type;
        this.url = url;
        this.description = description;
    }
}