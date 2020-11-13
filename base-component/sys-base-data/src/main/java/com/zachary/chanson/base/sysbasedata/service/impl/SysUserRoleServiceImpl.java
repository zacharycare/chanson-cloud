package com.zachary.chanson.base.sysbasedata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zachary.chanson.base.common.entity.SysUserRole;
import com.zachary.chanson.base.sysbasedata.mapper.SysUserRoleMapper;
import com.zachary.chanson.base.sysbasedata.service.SysUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
}
