package com.zachary.chanson.base.common.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("sys_permissions")
public class SysPermissions implements Serializable {
    private Long id;
    private String name;
    private String code;
    private String url;
    private char status;
    @TableLogic
    private Integer deleted;
}
