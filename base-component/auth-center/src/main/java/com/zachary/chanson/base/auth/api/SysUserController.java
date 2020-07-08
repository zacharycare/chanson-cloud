package com.zachary.chanson.base.auth.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "sys-user")
@Slf4j
public class SysUserController {

    @GetMapping(value = "current")
    public Principal user(Principal principal) {
        log.info("Principal-----------------------");
        return principal;
    }
}
