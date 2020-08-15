package com.zachary.chanson.base.sysbasedata.controller;

import com.zachary.chanson.base.common.entity.SysUser;
import com.zachary.chanson.base.common.util.ResultInfo;
import com.zachary.chanson.base.common.util.ResultUtil;
import com.zachary.chanson.base.sysbasedata.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "login")
@Slf4j
@PropertySource("classpath:wechat.properties")
public class LoginController {
    @Value(value = "${chanson-release.wx.appId}")
    String appId;
    @Value(value = "${chanson-release.wx.secret}")
    String secret;

    @Autowired
    SysUserService sysUserService;

    /**
     * 手机号+密码组合模式注册
     * @param map
     */
    @PostMapping(value = "register")
    public ResultInfo register(@RequestBody Map<String, String> map) {
        String tel = map.get("tel");
        String code = map.get("code");
        String password = map.get("password");

        // todo 手机号，密码格式长度等校验

        // todo 验证码校验redis
        if (!"1234".equals(code)) {
            return ResultUtil.failure("验证码错误");
        }

        SysUser user = new SysUser();
        user.setUsername(tel);  //初始注册默认手机号为登录用户名
        user.setTel(Long.parseLong(tel));
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        boolean result = sysUserService.save(user);
        if (result) {
            return ResultUtil.success(null);
        }

        return ResultUtil.failure("注册失败");
    }

    /**
     * todo
     * @param map
     * @return
     */
    @PostMapping(value = "getSmsValidCode")
    public ResultInfo getValidCode(@RequestBody Map<String, String> map) {
        String tel = map.get("tel");
        String smsCode = "123456";
        // 短信平台
        // tel : code 存入redis  用作后续验证
        return ResultUtil.success("验证码发送成功");
    }
}
