package com.zachary.chanson.base.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableFeignClients
public class AuthCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthCenterApplication.class, args);
    }
}
