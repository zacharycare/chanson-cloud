package com.zachary.chanson.base.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("sys_role")
public class SysRole {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    private String roleName;

    private String roleDesc;

    private String status;
    private String createdBy;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    private String updatedBy;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updatedDate;
    @TableLogic
    private Integer deleted;
}
