package com.zachary.chanson.busi.release.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zachary.chanson.busi.release.entity.Space;
import com.zachary.chanson.busi.release.mapper.SpaceMapper;
import com.zachary.chanson.busi.release.service.SpaceService;
import org.springframework.stereotype.Service;

@Service
public class SpaceServiceImpl extends ServiceImpl<SpaceMapper, Space> implements SpaceService {
}
