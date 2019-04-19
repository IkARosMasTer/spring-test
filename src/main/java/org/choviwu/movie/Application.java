package org.choviwu.movie;

import lombok.extern.slf4j.Slf4j;
import org.choviwu.movie.base.Gloal;
import org.choviwu.movie.config.*;
import org.choviwu.movie.mapper.ConfigMapper;
import org.choviwu.movie.model.Articles;
import org.choviwu.movie.model.Config;
import org.choviwu.movie.model.UserInput;
import org.choviwu.movie.util.WxUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = {"org.choviwu.movie.mapper"})
@EnableScheduling
@Slf4j
//@ComponentScan(basePackages = "org.choviwu.movie",
//		excludeFilters = {
//		@ComponentScan.Filter(type = FilterType.CUSTOM,classes = MovieTypeFilter.class)
//		}
//)
//@Import(value = {UserInput.class,
//		MovieImportSelector.class,
//		MovieImportBeanDefinitionRegistrar.class})
@EnableCaching
//@EnableAspectJAutoProxy
public class MovieApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MovieApplication.class, args);
//		UserInput us = context.getBean(UserInput.class);
//		UserInput us2 = context.getBean(UserInput.class);
//		Articles articles= context.getBean(Articles.class);
//		Object obj =  context.getBean("movieFactoryBean");
//		Object obj2 =  context.getBean("&movieFactoryBean");
//		System.out.println(us==us2);
//		System.out.println(articles);
//		System.out.println(obj);
//		System.out.println(obj2);
//		((ConfigurableApplicationContext) context).close();
	}
//	@Bean
//	public MovieFactoryBean movieFactoryBean(){
//		return new MovieFactoryBean();
//	}

//	@Scope("prototype")
//	@Bean
//	@Conditional(MovieCondition.class)
////	@ConditionalOnProperty(prefix = "spring.")
////	@ConditionalOnBean(MovieCondition.class)
//	public UserInput userInput(){
//		System.out.println(".........................................啊");
//		return new UserInput();
//	}

}
