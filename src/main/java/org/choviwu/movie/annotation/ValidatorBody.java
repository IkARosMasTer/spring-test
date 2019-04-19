package org.choviwu.movie.annotation;


import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidatorBody {

//    boolean isNull() default  true;


}
