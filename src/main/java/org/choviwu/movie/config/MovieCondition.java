package org.choviwu.movie.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class MovieCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();

        ClassLoader classLoader = conditionContext.getClassLoader();

        Environment environment = conditionContext.getEnvironment();

        BeanDefinitionRegistry registry = conditionContext.getRegistry();
//        classLoader.getClass().getName();
//        if()
//        MultiValueMap<String, Object> map =  annotatedTypeMetadata.getAllAnnotationAttributes("Conditional");
        if(environment.getProperty("os.name").toLowerCase().contains("windows")){
            return true;
        }
        return false;
    }
}
