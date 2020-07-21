package com.dzc.platoomcloud.common.exception;

import com.dzc.platoomcloud.common.response.ResultCode;

/**
 * 自定义异常抛出类
 * @author dzc
 * @date 2020/7/21
 */
public class ExceptionCast {

    public static ResultCode cast(ResultCode resultCode){
        throw new BizException(resultCode);
    }
}
