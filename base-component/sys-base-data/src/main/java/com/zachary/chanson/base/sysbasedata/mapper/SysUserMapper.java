package com.zachary.chanson.base.sysbasedata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zachary.chanson.base.common.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
