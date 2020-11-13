package com.zachary.chanson.base.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_user_role")
public class SysUserRole extends BaseEntity {
    private Long sysUserId;
    private Long sysRoleId;
    private String status;
}
