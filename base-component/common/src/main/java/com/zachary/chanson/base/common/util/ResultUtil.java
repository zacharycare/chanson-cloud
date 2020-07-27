package com.zachary.chanson.base.common.util;

public class ResultUtil {
    public ResultUtil(){}

    public static ResultInfo success(Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(ResultCode.SUCCESS.getCode());
        resultInfo.setMessage(ResultCode.SUCCESS.getMessage());
        resultInfo.setData(data);
        return resultInfo;
    }

    public static ResultInfo failure(String code, String message, Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(code);
        resultInfo.setMessage(message);
        resultInfo.setData(data);
        return resultInfo;
    }

    public static ResultInfo failure(ResultCode resultCode, Object data) {
        return failure(resultCode.getCode(), resultCode.getMessage(), data);
    }

    public static ResultInfo failure(ResultCode resultCode) {
        return failure(resultCode, null);
    }

    public static ResultInfo failure(String message) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(ResultCode.FAILURE.getCode());
        resultInfo.setMessage(message);
        resultInfo.setData(null);
        return resultInfo;
    }

}
