package com.lmy.friday.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2020-06-25 17:45:06
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = -50495331124222083L;
    // ID
    private Integer id;
    // 角色名称
    private String name;
    // 描述
    private String description;
    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
    // 更新时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;

}