package com.zachary.chanson.base.auth.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SysUserApi {
    @GetMapping(value = "register")
    @PreAuthorize(value = "")
    public void getSysUser() {
        log.info("getSysUser...");
    }
}
