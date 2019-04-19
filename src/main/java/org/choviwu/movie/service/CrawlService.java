package org.choviwu.movie.service;

import lombok.extern.slf4j.Slf4j;
import org.choviwu.movie.base.Constant;
import org.choviwu.movie.crawl.AbstractCrawl;
import org.choviwu.movie.crawl.KyunCrawl;
import org.choviwu.movie.crawl.SebXalCrawl;
import org.choviwu.movie.crawl.YingkeCrawl;
import org.choviwu.movie.mapper.ConfigMapper;
import org.choviwu.movie.mapper.MovieMapper;
import org.choviwu.movie.model.Movie;
import org.choviwu.movie.model.crawl.AbstractSpider;
import org.choviwu.movie.model.crawl.KyunSpider;
import org.choviwu.movie.model.crawl.SebXalSpider;
import org.choviwu.movie.model.crawl.YingkeSpider;
import org.choviwu.movie.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CrawlService {


    private final ConfigMapper configMapper;
    private final MovieMapper movieMapper;
    private Executor threadPool = Executors.newFixedThreadPool(10);
    private final MovieService movieService;

    @Autowired
    CrawlService(MovieMapper movieMapper, ConfigMapper configMapper,
                 MovieService movieService) {
        this.movieMapper = movieMapper;
        this.configMapper = configMapper;
        this.movieService = movieService;
    }

    public List<Movie> crawl(String content) {
        return crawlMovie(content);
    }


    private List<Movie> crawlMovie(final String content) {
        String type = configMapper.getDBValueByParam("movie_type_list");
        String[] typeList = type.split(",");
//        for (String str : typeList) {
//            if (content.contains(str)) {
//                log.info("电影类型： " + content);
//                return movieService.getListByType(str.substring(0, 2));
//            }
//        }
        //利用正则去掉标点符号
//        if (content.endsWith("。") || content.endsWith(",") || content.endsWith("!")) {
//            content = content.substring(0, content.length() - 1);
//            log.info("替换掉之后的为：" + currentContent);
//        }
        //普通电影爬虫
        List<Movie> list = movieMapper.getMovieListByName(content, Constant.FCW);
        log.info("=========List Size!!! : " + list.size() + "=========");
        if (list != null && list.size() > 0) {
            return list;
        }

        AbstractCrawl<AbstractSpider> sebXalCrawl = new SebXalCrawl();
        //拿锁  异步获取电影  主线程等待子线程执行完才返回
        CountDownLatch countDownLatch = new CountDownLatch(3);
        threadPool.execute(() -> {
            try {
                List<Map<String, String>> mapList = sebXalCrawl.searchMovie(new SebXalSpider(content));
                final List<Map<String, String>> currentList = mapList;
                // sebXalCrawl
                if (currentList != null) {
                    for (Map<String, String> map : currentList) {
                        String movieType = "sebXalCrawl";
                        insertMovie(map, movieType);
                    }
                }
            }catch (Exception e){
                log.info("Search ERROR : {}",e);
            }finally {
                countDownLatch.countDown();
                log.info("1当前线程进行数量： {}", countDownLatch.getCount());
            }
        });


        threadPool.execute(() -> {
            //17kyun
            try {
                AbstractCrawl<AbstractSpider> kyunCrawl = new KyunCrawl();
                final List<Map<String, String>> kyunList = kyunCrawl.searchMovie(new KyunSpider(content));
                if (kyunList != null) {
                    for (Map<String, String> map : kyunList) {
                        String movieType = "17kyun";
                        insertMovie(map, movieType);
                    }
                }
            }catch (Exception e){
                log.info("Search ERROR : {}",e);
            }finally {
                countDownLatch.countDown();
                log.info("2当前线程进行数量： {}", countDownLatch.getCount());
            }
        });

        threadPool.execute(() -> {
            try {
                //http://5.sebxal.cn
                AbstractCrawl<AbstractSpider> yingkeCrawl = new YingkeCrawl();
                List<Map<String, String>> mapList = yingkeCrawl.searchMovie(new YingkeSpider(content));
                if (mapList != null) {
                    for (Map<String, String> map : mapList) {
                        String movieType = "yingkeCrawl";
                        insertMovie(map, movieType);
                    }
                }
            } catch (Exception e) {
                log.info("Search ERROR : {}", e);
            }finally {
                countDownLatch.countDown();
                log.info("3当前线程进行数量： {}", countDownLatch.getCount());
            }
        });
        try {
            log.info("锁在等待 Start");
            countDownLatch.await(5, TimeUnit.SECONDS);
            log.info("锁在等待完毕 End");
        } catch (InterruptedException e) {
            log.info("InterruptedException ERROR : {}", e);
        }
        list = movieMapper.getMovieListByName(content, "");

        //有可能爬取失败
        log.info("=========获取成功 Success : " + list.size() + "=========");
        return list;
    }

    /**
     * 插入电影
     */
    private void insertMovie(Map<String, String> map, String type) {
        List<Movie> list = movieMapper.getMovieListByDesc(map.get("description"), "");
        if (list != null && list.size() > 0) {
            log.info("重复的电影名： " + map.get("title"));
        } else {
            Movie movie = new Movie();
            movie.setMovieName(map.get("title"));
            movie.setDescription(map.get("description"));
            movie.setMovieUpdateTime(DateUtils.formatDate(new Date(), "yyyy/MM/dd HH:mm:ss"));
            movie.setMovieLogo(map.get("logo"));
            movie.setActorList(movie.getDescription());
            movie.setUrl(map.get("url"));
            movie.setReferer(map.get("referer"));
            movie.setType(type);
            movie.setAddtime(new Date());
            movieMapper.insertSelective(movie);

            log.info("插入成功 : " + movie.getMovieName());
        }

    }
}
