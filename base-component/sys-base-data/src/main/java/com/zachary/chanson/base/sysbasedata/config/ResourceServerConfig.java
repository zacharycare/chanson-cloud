package com.zachary.chanson.base.sysbasedata.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    //该方法需要重写，否则报错 Cannot convert access token to JSON
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/actuator/**").permitAll()//不对springboot-admin监控的请求进行权限校验
                .antMatchers("/instances/**").permitAll()//不对springboot-admin监控的实例信息请求进行权限校验
        .anyRequest().authenticated();
    }
}
