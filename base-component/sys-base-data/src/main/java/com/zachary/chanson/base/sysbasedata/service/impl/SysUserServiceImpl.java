package com.zachary.chanson.base.sysbasedata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zachary.chanson.base.common.dto.AuthorizeSysUserRole;
import com.zachary.chanson.base.common.dto.SysRoleAndChecked;
import com.zachary.chanson.base.common.entity.SysRole;
import com.zachary.chanson.base.common.entity.SysUser;
import com.zachary.chanson.base.common.entity.SysUserRole;
import com.zachary.chanson.base.common.util.ResultInfo;
import com.zachary.chanson.base.common.util.ResultUtil;
import com.zachary.chanson.base.sysbasedata.mapper.SysUserMapper;
import com.zachary.chanson.base.sysbasedata.service.SysUserRoleService;
import com.zachary.chanson.base.sysbasedata.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    SysUserRoleService sysUserRoleService;
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public ResultInfo authorizeSysRole(AuthorizeSysUserRole authorizeSysUserRole, Principal principal) {
        try {
            sysUserRoleService.remove(new QueryWrapper<SysUserRole>().eq("sys_user_id", authorizeSysUserRole.getSysUserId()));
            List<SysUserRole> list = new ArrayList<>();
            SysUserRole sysUserRole;
            for (SysRole sysRole : authorizeSysUserRole.getAuthorities()) {
                sysUserRole = new SysUserRole();
                sysUserRole.setSysUserId(authorizeSysUserRole.getSysUserId());
                sysUserRole.setSysRoleId(sysRole.getId());
                list.add(sysUserRole);
            }
            sysUserRoleService.saveBatch(list);
        } catch (Exception e) {
            log.error("用户授权角色异常", e);
            return ResultUtil.failure(e.getMessage());
        }
        return ResultUtil.success(null);
    }

    @Override
    public List<SysRoleAndChecked> selectSysRoleAndChecked(Long sysUserId) {
        return sysUserMapper.selectSysRoleAndChecked(sysUserId);
    }
}
