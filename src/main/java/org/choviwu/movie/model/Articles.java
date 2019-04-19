package org.choviwu.movie.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.List;

@Component
public class Articles implements Serializable , InitializingBean, DisposableBean {

    private List<Item> item;

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    @Autowired
    public Articles(){

    }
    @PostConstruct
    public void post(){
        System.out.println("init .....................w a ");
    }
    @PreDestroy
    public void destory(){
        System.out.println(">>>>>>>>>>>>>>>>destory ...........");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("=============销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=================初始化");
    }
}
