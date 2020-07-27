package com.zachary.chanson.base.common.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user")
public class User extends BaseEntity {

    private Long id;

    private String username;

    private String password;

    private String nickName;

    private String gender;

    private String telNumber;

    private String email;

    private String status;

    private String registerType;

    private String address;

    private String wxOpenid;

    private String wxSessionKey;

    @TableLogic
    private Integer deleted;
}
