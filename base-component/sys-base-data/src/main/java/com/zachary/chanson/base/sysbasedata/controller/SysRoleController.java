package com.zachary.chanson.base.sysbasedata.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zachary.chanson.base.common.entity.SysRole;
import com.zachary.chanson.base.common.util.ResultCode;
import com.zachary.chanson.base.common.util.ResultInfo;
import com.zachary.chanson.base.common.util.ResultUtil;
import com.zachary.chanson.base.sysbasedata.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "sysRole")
@Slf4j
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @PostMapping(value = "save")
    public ResultInfo save(@RequestBody SysRole sysRole, Principal principal) {
        try {
            sysRole.setCreatedBy(principal.getName());
            boolean flag = sysRoleService.saveOrUpdate(sysRole);
            if (flag) {
                return ResultUtil.success(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("保存系统角色异常", e);
            return ResultUtil.failure(ResultCode.FAILURE,e.getMessage());
        }
        return ResultUtil.failure(ResultCode.FAILURE);
    }

    @PostMapping(value = "selectPage", name = "分页查询系统角色")
    public IPage<SysRole> selectPageData(@RequestBody Map<String, Integer> page) {
        return sysRoleService.page(new Page<>(page.get("current"), page.get("pageSize")));
    }

    @GetMapping(value = "listAll", name = "查询所有系统角色")
    public List<SysRole> selectAll() {
        return sysRoleService.list();
    }

    @PostMapping(value = "delete", name = "删除系统用户")
    public ResultInfo delSysUser(@RequestBody String[] ids) {
        try {
            sysRoleService.removeByIds(Arrays.asList(ids));
            return ResultUtil.success(null);
        } catch (Exception e) {
            log.error("删除系统角色异常", e);
            return ResultUtil.failure(ResultCode.FAILURE,e.getMessage());
        }
    }
}
