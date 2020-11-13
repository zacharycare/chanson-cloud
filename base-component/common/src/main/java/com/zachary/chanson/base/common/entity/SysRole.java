package com.zachary.chanson.base.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {
//    @JSONField(serializeUsing = ToStringSerializer.class)
//    private Long id;

    private String roleCode;

    private String roleName;

    private String roleDesc;

    private String status;

//    private String createdBy;
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date createdDate;
//    private String updatedBy;
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date updatedDate;
//    @TableLogic
//    private Integer deleted;
}
