package com.zachary.chanson.base.auth.config;

import com.zachary.chanson.base.auth.feign.SysUserFeignService;
import com.zachary.chanson.base.auth.service.SysUserService;
import com.zachary.chanson.base.common.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserDetailService implements UserDetailsService {
    final
    SysUserService sysUserService;

    public UserDetailService(SysUserService sysUserService, SysUserFeignService sysUserFeignService) {
        this.sysUserService = sysUserService;
        this.sysUserFeignService = sysUserFeignService;
    }

    final
    SysUserFeignService sysUserFeignService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("UserDetailService--username is {}",s);
        SysUser sysUser = sysUserFeignService.getSysUserByUsername(s);
        log.info("feign sys user-->{}", sysUser);
        if (sysUser == null) {
            throw new UsernameNotFoundException("the user not found");
        } else {
            //获取用户角色
            List<String> roles = sysUserService.selectSysUserRole(s);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
            log.info("loadUserByUsername--sys user:{}", sysUser);
            return new User(s, sysUser.getPassword(), authorities);
        }
    }
}
