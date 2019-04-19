package org.choviwu.movie.config;

import org.choviwu.movie.model.Articles;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotationMetadata;

public class MovieImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {

        boolean flagArticle = registry.containsBeanDefinition("org.choviwu.movie.model.Articles");

        if(!flagArticle) {
            BeanDefinition definition = new RootBeanDefinition(Articles.class);
            registry.registerBeanDefinition("articles",definition);
        }

    }
}
