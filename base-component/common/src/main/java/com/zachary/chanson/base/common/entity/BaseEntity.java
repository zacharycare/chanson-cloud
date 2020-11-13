package com.zachary.chanson.base.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 所有entity继承该基础entity
 */
@Data
public class BaseEntity implements Serializable {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    private String createdBy;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    private String updatedBy;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updatedDate;
    @TableLogic
    private Integer deleted;
}
