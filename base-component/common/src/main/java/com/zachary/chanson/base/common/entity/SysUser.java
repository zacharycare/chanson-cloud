package com.zachary.chanson.base.common.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_user")
public class SysUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
    private char status = '1';
    private String createdBy;
    private Date createdDate;
    @TableLogic
    private Integer deleted;
}
