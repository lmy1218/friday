package com.lmy.friday.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysRoleUser)实体类
 *
 * @author makejava
 * @since 2020-06-25 17:45:06
 */
@Data
public class SysRoleUser implements Serializable {
    private static final long serialVersionUID = 339533683088311822L;
    // 用户ID
    private Integer userid;
    // 角色ID
    private Integer roleid;

}