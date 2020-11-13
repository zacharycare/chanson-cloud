package com.zachary.chanson.base.common.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.zachary.chanson.base.common.entity.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleAndChecked extends SysRole {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long sysUserId;
}
