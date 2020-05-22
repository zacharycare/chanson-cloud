package com.zachary.chanson.base.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zachary.chanson.base.auth.mapper.SysUserMapper;
import com.zachary.chanson.base.auth.service.SysUserService;
import com.zachary.chanson.base.common.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<String> selectSysUserRole(String username) {
        return sysUserMapper.selectSysUserRole(username);
    }
}
