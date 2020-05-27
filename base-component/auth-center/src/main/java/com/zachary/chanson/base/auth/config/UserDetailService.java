package com.zachary.chanson.base.auth.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zachary.chanson.base.auth.service.SysUserService;
import com.zachary.chanson.base.common.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("UserDetailService--username is {}",s);
        //feign 查询用户
        SysUser sysUserTemp = new SysUser();
        sysUserTemp.setUsername(s);
        sysUserTemp.setStatus('1');
        SysUser sysUser = sysUserService.getOne(new QueryWrapper<SysUser>(sysUserTemp));
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
