package com.zachary.chanson.base.sysbasedata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zachary.chanson.base.common.entity.SysPermissions;
import com.zachary.chanson.base.sysbasedata.mapper.SysPermissionsMapper;
import com.zachary.chanson.base.sysbasedata.service.SysPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionsServiceImpl extends ServiceImpl<SysPermissionsMapper, SysPermissions> implements SysPermissionsService {
    @Autowired
    SysPermissionsMapper sysPermissionsMapper;

    @Override
    public Integer selectSysPermissionsCount() {
        return sysPermissionsMapper.selectSysPermissionsCount();
    }
}
