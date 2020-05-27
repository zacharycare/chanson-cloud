package com.zachary.chanson.base.sysbasedata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zachary.chanson.base.common.entity.SysUser;
import com.zachary.chanson.base.sysbasedata.mapper.SysUserMapper;
import com.zachary.chanson.base.sysbasedata.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
