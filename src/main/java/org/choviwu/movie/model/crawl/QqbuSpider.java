package org.choviwu.movie.model.crawl;

import org.choviwu.movie.Enums.RefererEnum;

public class QqbuSpider extends AbstractSpider {

    public QqbuSpider(String movieName) {

        super(RefererEnum.QQB.getReferer(), movieName);
    }
    public QqbuSpider(){super(RefererEnum.QQB.getReferer());}
}
