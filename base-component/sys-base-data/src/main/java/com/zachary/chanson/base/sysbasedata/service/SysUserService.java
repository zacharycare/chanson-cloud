package com.zachary.chanson.base.sysbasedata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zachary.chanson.base.common.dto.AuthorizeSysUserRole;
import com.zachary.chanson.base.common.dto.SysRoleAndChecked;
import com.zachary.chanson.base.common.entity.SysUser;
import com.zachary.chanson.base.common.util.ResultInfo;

import java.security.Principal;
import java.util.List;

public interface SysUserService extends IService<SysUser> {
    ResultInfo authorizeSysRole(AuthorizeSysUserRole authorizeSysUserRole, Principal principal);

    List<SysRoleAndChecked> selectSysRoleAndChecked(Long sysUserId);
}
