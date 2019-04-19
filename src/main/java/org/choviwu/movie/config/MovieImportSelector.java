package org.choviwu.movie.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotationMetadata;

public class MovieImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {


        return new String[]{"org.choviwu.movie.model.Articles"};
    }
}
