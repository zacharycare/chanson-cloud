package com.zachary.chanson.base.auth.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
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

    @Autowired
    ConsumerTokenServices consumerTokenServices;

    /**
     * 退出登录，清除token
     **/
    @GetMapping("/removeToken")
    public Boolean removeToken(String accessToken){
        return consumerTokenServices.revokeToken(accessToken);
    }

}
