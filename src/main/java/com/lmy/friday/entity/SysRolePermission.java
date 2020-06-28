package com.lmy.friday.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysRolePermission)实体类
 *
 * @author makejava
 * @since 2020-06-25 17:45:06
 */
@Data
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = -90056515479909588L;
    // 角色id
    private Integer roleId;
    // 权限id
    private Integer permissionId;

}