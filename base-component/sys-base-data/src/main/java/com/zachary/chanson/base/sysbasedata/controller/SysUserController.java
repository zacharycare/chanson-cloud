package com.zachary.chanson.base.sysbasedata.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zachary.chanson.base.common.entity.SysUser;
import com.zachary.chanson.base.common.util.ResultCode;
import com.zachary.chanson.base.common.util.ResultInfo;
import com.zachary.chanson.base.common.util.ResultUtil;
import com.zachary.chanson.base.sysbasedata.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
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

    @PostMapping(value = "save", name = "保存系统用户--新增或更新")
    public ResultInfo saveSysUser(@RequestBody SysUser sysUser, Principal principal) {
        try {
            log.info("当前操作用户-->{}", principal.getName());
            sysUser.setCreatedBy(principal.getName());
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
            boolean result = sysUserService.saveOrUpdate(sysUser);
            if (result) {
                return ResultUtil.success(null);
            }
        } catch (Exception e) {
            return ResultUtil.failure(ResultCode.FAILURE,e.getMessage());
        }
        return ResultUtil.failure(ResultCode.FAILURE);
    }

    @PostMapping(value = "delete", name = "删除系统用户")
    public ResultInfo delSysUser(@RequestBody String[] ids) {
        try {
            sysUserService.removeByIds(Arrays.asList(ids));
            return ResultUtil.success(null);
        } catch (Exception e) {
            log.error("删除系统用户异常", e);
            return ResultUtil.failure(ResultCode.FAILURE,e.getMessage());
        }
    }

    @GetMapping(value = "detail", name = "系统用户详情")
    public ResultInfo detailSysUser(String id) {
        try {
            return ResultUtil.success(sysUserService.getById(id));
        } catch (Exception e) {
            log.error("获取系统用户详情异常", e);
            return ResultUtil.failure(ResultCode.FAILURE,e.getMessage());
        }
    }

    /**
     * 获取个人信息
     * @return
     */
    @PostMapping(value = "getPersonInfo")
    public ResultInfo getSysUserByUsername(@RequestBody SysUser sysUser) {
        sysUser = sysUserService.getOne(new QueryWrapper<SysUser>().eq("username", sysUser.getUsername()));
        return ResultUtil.success(sysUser);
    }
}
