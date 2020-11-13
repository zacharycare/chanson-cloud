package com.zachary.chanson.base.sysbasedata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zachary.chanson.base.common.dto.SysRoleAndChecked;
import com.zachary.chanson.base.common.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysRoleAndChecked> selectSysRoleAndChecked(@Param("sysUserId") Long sysUserId);
}
