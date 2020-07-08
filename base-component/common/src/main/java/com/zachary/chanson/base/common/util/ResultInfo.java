package com.zachary.chanson.base.common.util;

import lombok.Data;

@Data
public class ResultInfo<T> {
    private String code;
    private String message;
    private T data;
}
