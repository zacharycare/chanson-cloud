package com.zachary.chanson.base.sysbasedata.controller;

import com.zachary.chanson.base.common.entity.SysUser;
import com.zachary.chanson.base.sysbasedata.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @GetMapping(value = "getUsers",name = "查询所有系统用户")
    public List<SysUser> getUsers() {
        return sysUserService.list();
    }
}
