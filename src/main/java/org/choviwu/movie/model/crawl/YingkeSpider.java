package org.choviwu.movie.model.crawl;

import java.io.Serializable;

public class YingkeSpider extends AbstractSpider implements Serializable{


    public YingkeSpider(String movieName) {
        super( "http://touk.m8c8c.com/",movieName);
    }
    public YingkeSpider(){
        super( "http://5.sebxal.cn");
    }
}
