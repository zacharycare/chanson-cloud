package com.zachary.chanson.base.common.util;

public enum ResultCode {

    SUCCESS("000000", "操作成功"),
    FAILURE("999999", "操作失败");

    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
