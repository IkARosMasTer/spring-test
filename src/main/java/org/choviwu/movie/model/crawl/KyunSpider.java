package org.choviwu.movie.model.crawl;

import org.choviwu.movie.Enums.RefererEnum;
import org.choviwu.movie.base.Constant;
import org.choviwu.movie.base.Gloal;
import org.choviwu.movie.util.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class KyunSpider extends AbstractSpider implements Serializable{


    public KyunSpider(String movieName) {
        super( RefererEnum.KYUN.getReferer(),movieName);
    }
    public KyunSpider(){
        super( RefererEnum.KYUN.getReferer());
    }
}
