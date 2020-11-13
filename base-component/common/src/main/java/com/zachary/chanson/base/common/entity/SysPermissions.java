package com.zachary.chanson.base.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_permissions")
public class SysPermissions implements Serializable {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String name;
    private String code;
    private String url;
    private Long pId;
    private String type;
    private char status;
    private String createdBy;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    private String updatedBy;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updatedDate;
    @TableLogic
    private Integer deleted;
}
