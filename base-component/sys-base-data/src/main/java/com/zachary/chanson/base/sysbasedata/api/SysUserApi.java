package com.zachary.chanson.base.sysbasedata.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysUserApi {

    @GetMapping(value = "hello")
    public String hello(String name) {
        return "hello:" + name;
    }
}
