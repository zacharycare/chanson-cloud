package com.zachary.chanson.base.sysbasedata.api;

import com.alibaba.fastjson.JSONObject;
import com.zachary.chanson.base.common.entity.SysUser;
import com.zachary.chanson.base.common.entity.User;
import com.zachary.chanson.base.common.util.HttpClientUtil;
import com.zachary.chanson.base.common.util.ResultInfo;
import com.zachary.chanson.base.common.util.ResultUtil;
import com.zachary.chanson.base.sysbasedata.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.Map;

@RestController
@Slf4j
@PropertySource("classpath:wechat.properties")
public class SysUserApi {

    @Value(value = "${chanson-release.wx.appId}")
    String appId;
    @Value(value = "${chanson-release.wx.secret}")
    String secret;

    @Autowired
    UserService userService;

    @GetMapping(value = "hello")
    public String hello(String name) {
        return "hello:" + name;
    }

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

        User user = new User();
        user.setUsername(tel);  //初始注册默认手机号为登录用户名
        user.setTelNumber(tel);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        boolean result = userService.save(user);
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

    /**
     * todo
     * @param map
     */
    @PostMapping("wx/login")
    public void wxLogin(@RequestBody Map<String, String> map) {
        log.info("wxLogin--enter.............");
        log.info(JSONObject.toJSONString(map));
        String clientId = map.get("client_id");
        String clientSecret = map.get("client_secret");
        String wxCode = map.get("code");
        log.info("接口入参-->" + clientId + ":" + clientSecret);
        log.info("微信入参-->" + appId + ":" + secret + wxCode);
        String code2SessionUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + wxCode + "&grant_type=authorization_code";
        try {
            HttpResponse response = HttpClientUtil.get(code2SessionUrl);
            Object responseBody = response.body();
            log.info("wx-code2Session-->{}", JSONObject.toJSONString(responseBody));
            JSONObject object = JSONObject.parseObject(responseBody.toString());
            String openId = object.getString("openid");
            String sessionKey = object.getString("session_key");
            if (StringUtils.isNotBlank(openId) && StringUtils.isNotBlank(sessionKey)) {
                User user = new User();
                user.setWxOpenid(openId);
                user.setWxSessionKey(sessionKey);
                userService.save(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
