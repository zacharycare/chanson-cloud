package com.zachary.chanson.base.sysbasedata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zachary.chanson.base.common.entity.SysPermissions;

public interface SysPermissionsService extends IService<SysPermissions> {
    Integer selectSysPermissionsCount();
}
