package org.choviwu.movie.model.crawl;

import org.choviwu.movie.model.Movie;
import org.choviwu.movie.util.DateUtils;

import java.util.Date;

public abstract class AbstractSpider extends Spider{

    public Movie getMovie() {
        return movie;
    }

    protected Movie movie;
    protected String url ;
    protected String referer;
    protected String movieName;
    public AbstractSpider(String referer,String movieName){
        movie = new Movie();
//        this.url = url;
        this.referer = referer;
        this.movieName = movieName;
        create(referer);
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public AbstractSpider(String referer){
        movie = new Movie();
        this.referer = referer;create(referer);}
    private void create(String referer){
        movie.setAddtime(new Date());
        movie.setMovieUpdateTime(DateUtils.formatDate(new Date(),"yyyy/MM/dd HH:mm:ss"));
        movie.setReferer(referer);
//        movie.setUrl(url);
        movie.setMovieName(movieName);
    }


}
