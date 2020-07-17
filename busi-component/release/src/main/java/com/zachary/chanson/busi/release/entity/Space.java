package com.zachary.chanson.busi.release.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 空间资源
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("release_space")
public class Space extends BaseEntity {

    private Long id;

    private String name;

    private String code;

    private String address;

    private String status;

    private String remark;

    @TableLogic
    private Integer deleted;

    @JsonSerialize(using = ToStringSerializer.class)
    public Long getId() {
        return id;
    }
}
