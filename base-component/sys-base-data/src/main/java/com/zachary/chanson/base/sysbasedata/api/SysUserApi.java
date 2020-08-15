package com.zachary.chanson.base.sysbasedata.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zachary.chanson.base.common.entity.SysUser;
import com.zachary.chanson.base.common.util.ResultInfo;
import com.zachary.chanson.base.common.util.ResultUtil;
import com.zachary.chanson.base.sysbasedata.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class SysUserApi {

    @Autowired SysUserService sysUserService;

    @PostMapping(value = "getSysUserByUsername")
    public SysUser getSysUserByUsername(String username) {
        return sysUserService.getOne(new QueryWrapper<SysUser>().eq("username", username));
    }
}
