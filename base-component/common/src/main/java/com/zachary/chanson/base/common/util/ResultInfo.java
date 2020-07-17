package com.zachary.chanson.base.common.util;

import lombok.Data;

@Data
public class ResultInfo {
    private String code;
    private String message;
    private Object data;
}
