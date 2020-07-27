package com.zachary.chanson.base.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 所有entity继承该基础entity
 */
@Data
public class BaseEntity implements Serializable {

    private String createdBy;

    private String createdDate;

    private String updatedBy;

    private String updatedDate;
}
