package org.choviwu.movie.annotation;


import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Response {

//    boolean isNull() default  true;


}
