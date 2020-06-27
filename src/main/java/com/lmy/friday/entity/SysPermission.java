package com.lmy.friday.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (SysPermission)实体类
 *
 * @author makejava
 * @since 2020-06-25 17:45:02
 */
@Data
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -45928866815537190L;
    // ID
    private Integer id;
    // 父ID
    private Integer parentid;
    // 权限名称
    private String name;
    // css样式名
    private String css;
    // 跳转URL
    private String href;
    // 类型
    private Integer type;
    // 权限
    private String permission;
    // 排序
    private Integer sort;


    private List<SysPermission> child;

}