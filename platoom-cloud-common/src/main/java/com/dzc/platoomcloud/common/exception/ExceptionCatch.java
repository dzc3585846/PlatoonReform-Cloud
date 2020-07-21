package com.dzc.platoomcloud.common.exception;

import com.dzc.platoomcloud.common.response.CommonCode;
import com.dzc.platoomcloud.common.response.ResultCode;
import com.dzc.platoomcloud.common.response.ResponseResult;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获配置类
 * @author dzc
 * @date 2020/7/21
 */
@Slf4j
@ControllerAdvice //springmvc控制器增强
public class ExceptionCatch {
    /**
     * 定义map，配置异常类型所对应的错误代码
     */
    protected static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;

    /**
     *  定义map的build对象，去构建ImmutableMap
     */
    private static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    static {
        //定义异常类型所对应的错误代码
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);
    }

    //捕获BizException此类异常（自定义可预知异常）
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public ResponseResult customException(BizException bizException){
        //记录异常日志
        log.error("catch exception {}",bizException.getMessage());
        ResultCode resultCode = bizException.getResultCode();
        return new ResponseResult(resultCode);
    }

    //捕获不可预知异常，即框架和系统异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception){
        //记录异常日志
        log.error("catch exception {}",exception.getMessage());
        if (EXCEPTIONS == null){
            EXCEPTIONS = builder.build();
        }
        //从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用，如果找不到给用户响应99999
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (null != resultCode){
            return new ResponseResult(resultCode);
        }else{
            //返回服务器异常
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }

    }




}
