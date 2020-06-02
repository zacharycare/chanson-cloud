package com.zachary.chanson.base.common.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class SysUserExcelDto implements Serializable {
    private Long id;
    private String username;
    private String email;
}
