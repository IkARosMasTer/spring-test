package org.choviwu.movie.config.returnhandler;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

/**
 * @author ChoviWu  2019年4月18日17:41:48
 */
@Slf4j
public class EmptyFieldReturnValueHandler implements HandlerMethodReturnValueHandler {

    protected final HandlerMethodReturnValueHandler handlerMethodReturnValueHandler;

    private final ReturnSelectorAdapter returnSelectorAdapter;

    public EmptyFieldReturnValueHandler(HandlerMethodReturnValueHandler handlerMethodReturnValueHandler) {
        this.handlerMethodReturnValueHandler = handlerMethodReturnValueHandler;
        this.returnSelectorAdapter = NullToEmptyUtil.getInstance().getReturnSelectorAdapter();

    }


    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ResponseBody.class) ||
                returnType.hasMethodAnnotation(ResponseBody.class));
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType,
                                  ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        long startTime = System.currentTimeMillis();
        Field[] fields = returnValue.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                //获取字段 注解
                if (field.isAnnotationPresent(NullToEmpty.class)) {
                    Object value = field.get(returnValue);
                    List<?> list = null;
                    if (value instanceof List) {
                        list = (List<?>) value;
                    }
                    if (list != null) {
                        list.forEach(this::setProperties);
                    } else {
                        //被修饰的字段必须是包装类型 否则错误
                        Optional.of(value).ifPresent(this::setProperties);
                    }
                }
            } catch (Exception e) {
                log.error("Exception :", e);
            }
        }
        // true false  是否对responsebody注解做拦截 自定义返回?
        // mavContainer.setRequestHandled();
        log.info("实际处理时间：{} ms", (System.currentTimeMillis() - startTime));

        //ResponseBody注解执行器
        handlerMethodReturnValueHandler.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }

    protected void setProperties(Object obj) {
        //被修饰的字段必须是包装类型 否则错误
        List<?> list = null;
        //分页对象另算
        if (obj instanceof PageInfo) {
            try {
                Field field = obj.getClass().getDeclaredField("list");
                field.setAccessible(true);
                List<?> objRet = (List<?>) field.get(obj);
                list = objRet;
            } catch (Exception e) {
                log.error("Error :", e);
            }
        }
        if (list != null) {
            list.forEach(this::setProperties);
        }
        List<Field> valueFields = NullToEmptyUtil.getInstance().getSuperFields(obj.getClass(), Lists.newArrayList());
        valueFields.forEach(valueField -> {
            //如果对象套对象
            valueField.setAccessible(true);
            try {
                //字段上如果有该注解   处理
                if (valueField.isAnnotationPresent(NullToEmpty.class)) {
                    NullToEmpty empty = valueField.getAnnotation(NullToEmpty.class);
                    boolean toTrim = empty.toTrim() ? true : empty.toTrim();
                    boolean toNull = empty.toNull() ? true : empty.toNull();
                    String text = empty.text();
                    toTrimOrNull(toTrim, valueField, obj, text);
                    toTrimOrNull(toNull, valueField, obj, text);
                } else {
                    toTrimOrNull(true, valueField, obj, "");
                }

            } catch (IllegalAccessException e) {
                log.info("Exception : {}", e);
            }
        });
    }

    protected void dealFieldValue(Field valueField, Object obj,
                                  Object fieldValue, String text) {
        //类型判断
        try {
            returnSelectorAdapter.match(obj, fieldValue, valueField, text);
        } catch (Exception e) {
            log.error("Error : ", e);
        }

    }

    /**
     * 重载ToTrim Null 方法
     */
    protected void toTrimOrNull(boolean flag, Field valueField, Object obj, String text) throws IllegalAccessException {
        toTrimOrNull(flag, valueField, obj, valueField.get(obj), text);
    }

    protected void toTrimOrNull(Field valueField, Object obj, Object fieldValue) throws IllegalAccessException {
        toTrimOrNull(true, valueField, obj, fieldValue, "");
    }

    private void toTrimOrNull(boolean flag, Field valueField, Object obj, Object fieldValue, String text) throws IllegalAccessException {
        if (flag) {
            dealFieldValue(valueField, obj, fieldValue, text);
        }
    }


}
