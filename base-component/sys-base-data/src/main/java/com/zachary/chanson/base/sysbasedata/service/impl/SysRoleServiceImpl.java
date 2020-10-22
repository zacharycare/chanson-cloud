package com.zachary.chanson.base.sysbasedata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zachary.chanson.base.common.entity.SysRole;
import com.zachary.chanson.base.sysbasedata.mapper.SysRoleMapper;
import com.zachary.chanson.base.sysbasedata.service.SysRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
