package com.zachary.chanson.base.common.dto;

import com.zachary.chanson.base.common.entity.SysRole;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class AuthorizeSysUserRole implements Serializable {
    private Long sysUserId;
    private List<SysRole> authorities;
}
