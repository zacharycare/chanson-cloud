package com.zachary.chanson.base.auth.feign;

import com.zachary.chanson.base.common.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SYS-BASE-DATA")
public interface SysUserFeignService {
    @PostMapping(value = "getSysUserByUsername",name = "查询所有系统用户")
    SysUser getSysUserByUsername(@RequestParam("username") String username);
}
