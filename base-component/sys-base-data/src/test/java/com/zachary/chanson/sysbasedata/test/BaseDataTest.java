package com.zachary.chanson.sysbasedata.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zachary.chanson.base.common.entity.SysUser;
import com.zachary.chanson.base.sysbasedata.SysBaseDataApplication;
import com.zachary.chanson.base.sysbasedata.mapper.SysPermissionsMapper;
import com.zachary.chanson.base.sysbasedata.service.SysPermissionsService;
import com.zachary.chanson.base.sysbasedata.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@SpringBootTest(classes = SysBaseDataApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseDataTest {
    @Autowired
    SysUserService sysUserService;
//    @Autowired
//    SysRoleService sysRoleService;
    @Autowired
    SysPermissionsService sysPermissionsService;
    @Autowired
    SysPermissionsMapper sysPermissionsMapper;

    @Test
    public void contextLoads() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        SysUser sysUser = new SysUser();
        sysUser.setUsername("zachary1");
        sysUser.setPassword(encoder.encode("zachary"));
        sysUser.setEmail("qwe@qq.com");
        sysUser.setCreatedBy("system");
        sysUser.setCreatedDate(new Date());
        boolean flag = sysUserService.save(sysUser);
        System.out.println("保存用户是否成功：" + flag);
        System.out.println("----------------------------");
        System.out.println(sysUserService.list());
    }

//    @Test
//    public void contextLoadsSysRole() {
//        SysRole sysRole = new SysRole();
//        sysRole.setRoleName("超管");
//        sysRole.setRoleDesc("超级管理员，拥有系统所有权限");
//        sysRole.setStatus(1);
//        boolean flag = sysRoleService.save(sysRole);
//        System.out.println("保存角色是否成功：" + flag);
//        System.out.println("----------------------------");
//        System.out.println(sysRoleService.list());
//    }

    @Test
    public void contextLoadsSysUser() {
        SysUser sysUserTemp = new SysUser();
        sysUserTemp.setUsername("admin1");
        sysUserTemp.setStatus('0');
        SysUser sysUser = sysUserService.getOne(new QueryWrapper<SysUser>(sysUserTemp));
        System.out.println(sysUser);
    }

    @Test
    public void contextLoadsSysPermissions() {
        System.out.println("======test======");
        System.out.println(sysPermissionsService.selectSysPermissionsCount());
        System.out.println(sysPermissionsMapper.selectSysPermissionsCount());
    }
}
