package com.zachary.chanson.base.sysbasedata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zachary.chanson.base.common.entity.User;
import com.zachary.chanson.base.sysbasedata.mapper.UserMapper;
import com.zachary.chanson.base.sysbasedata.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
