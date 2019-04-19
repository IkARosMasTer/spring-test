package org.choviwu.movie.model.crawl;

import org.choviwu.movie.Enums.RefererEnum;

import java.io.Serializable;

public class SebXalSpider extends AbstractSpider implements Serializable{


    public SebXalSpider(String movieName) {
        super( "http://5.sebxal.cn",movieName);
    }
    public SebXalSpider(){
        super( "http://5.sebxal.cn");
    }
}
