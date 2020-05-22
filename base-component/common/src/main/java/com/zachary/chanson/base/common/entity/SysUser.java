package com.zachary.chanson.base.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_user")
public class SysUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
    private int status;
    private String createdBy;
}
