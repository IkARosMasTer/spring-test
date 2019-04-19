package org.choviwu.movie.annotation;


import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validator {

//    boolean isNull() default  true;


}
