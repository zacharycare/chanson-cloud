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
    private String nickName;
    private Long tel;
    private String email;
    private String gender;
    private String birthday;
    private String registerSource;
    private String status;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    @TableLogic
    private Integer deleted;
}
