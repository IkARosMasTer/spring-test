package org.choviwu.movie.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReturnNull {

    String text() default "";

    boolean isBz() default false;
}
