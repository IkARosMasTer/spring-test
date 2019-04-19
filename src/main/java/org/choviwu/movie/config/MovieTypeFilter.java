package org.choviwu.movie.config;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MovieTypeFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader,
                         MetadataReaderFactory metadataReaderFactory) throws IOException {

        AnnotationMetadata metadata = metadataReader.getAnnotationMetadata();
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        String name = classMetadata.getClassName();
//        System.out.println(name);
//        System.out.println(">>>>>>>>>>>>>>>  " + name);
        if (name.contains("er")) {
            System.out.println(name);
            return true;
        }
        return false;
    }
}
