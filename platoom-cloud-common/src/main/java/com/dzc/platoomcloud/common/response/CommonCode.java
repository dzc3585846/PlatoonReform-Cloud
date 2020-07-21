package com.dzc.platoomcloud.common.response;

import lombok.ToString;


/**
 * 通用code
 */
@ToString
public enum CommonCode implements ResultCode {

    SUCCESS(true,200, "成功"),
    PARAM_ERROR(false,400, "参数错误"),
    FORBIDDEN(false,403, "禁止访问"),
    NOT_FOUND(false,404, "资源不存在"),
    REQUEST_METHOD_NOT_SUPPORTED(false,405, "不支持的请求方法"),
    SERVER_LIMIT(false,429, "服务限流"),
    SERVER_ERROR(false,500, "抱歉，系统繁忙，请稍后重试！"),
    SERVER_DOWNGRADE(false,700, "服务降级"),
    TOKEN_TIMEOUT(false,800, "登录信息过期"),
    INVALID_PARAM(false,10003,"非法参数"),
    FAIL(false,11111,"操作失败！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！");


//    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}
