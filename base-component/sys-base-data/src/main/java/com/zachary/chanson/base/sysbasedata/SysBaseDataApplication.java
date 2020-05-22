package com.zachary.chanson.base.sysbasedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SysBaseDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysBaseDataApplication.class,args);
    }
}
