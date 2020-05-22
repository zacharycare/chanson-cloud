package com.zachary.chanson.base.auth.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zachary.chanson.base.common.entity.SysUser;

import java.util.List;

public interface SysUserService extends IService<SysUser> {
    List<String> selectSysUserRole(String username);
}
