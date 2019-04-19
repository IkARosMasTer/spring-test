package org.choviwu.movie.config.returnhandler;


import java.lang.annotation.*;

@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface NullToEmpty {

    boolean toTrim() default true;

    boolean toNull() default false;

    Class<? extends ReturnSelector> clazz() default ObjectReturnSelector.class;
    /**
     * 是否包装类型
     * @return
     */
    boolean isObj() default false;

    String text() default "";
}
