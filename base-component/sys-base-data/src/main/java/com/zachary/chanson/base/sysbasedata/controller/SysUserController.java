package com.zachary.chanson.base.sysbasedata.controller;

import com.zachary.chanson.base.common.entity.SysUser;
import com.zachary.chanson.base.sysbasedata.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @GetMapping(value = "getUsers",name = "查询所有系统用户")
    public List<SysUser> getUsers() {
        log.info("getUser................");
        return sysUserService.list();
    }
}
