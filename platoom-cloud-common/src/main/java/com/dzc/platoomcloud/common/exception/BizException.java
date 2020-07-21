package com.dzc.platoomcloud.common.exception;

import com.dzc.platoomcloud.common.response.ResultCode;

/**
 * 自定义业务异常
 * @author dzc
 * @date 2020/7/21
 */
public class BizException extends RuntimeException {

    private ResultCode resultCode;

    public BizException(ResultCode resultCode) {
        super(resultCode.message());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public BizException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }
}
