package org.choviwu.movie.config.returnhandler;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Ignored {
}
