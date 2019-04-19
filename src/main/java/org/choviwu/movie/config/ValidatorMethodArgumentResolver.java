package org.choviwu.movie.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.choviwu.movie.annotation.Validator;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author ChoviWu
 */
@Slf4j
public class ValidatorMethodArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 参数有没有这个注解  有的话才能执行下一个方法
     *
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(Validator.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {

        final StringBuilder value = new StringBuilder();
        String methodParameterName = methodParameter.getParameter().getName();
        AtomicBoolean flag = new AtomicBoolean(false);
        Set<Map.Entry<String,String[]>> set = nativeWebRequest.getParameterMap().entrySet();
        //传参
                set.forEach(paramter -> {
                    log.info(">>>>>>>>> Parameter >>>>>>> {}, >>>>>>>>> Value : {}",paramter.getKey(),paramter.getValue()[0]);
                    if (methodParameterName.equals(paramter.getKey())) {
                        //cas
                        flag.compareAndSet(false,true);
                        if (StringUtils.isBlank(paramter.getValue()[0])) {
                            throw new IllegalArgumentException(paramter.getKey() + " is Not Null");
                    }
                        value.append(paramter.getValue()[0]);
                    }
                });
        //if foreach not scan vararible
        if(!flag.get()){
            throw new IllegalArgumentException(methodParameterName + " is Not Null");
        }
        return value.toString();
    }
}
