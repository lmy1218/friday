package com.lmy.friday.dto;
/**
 * @Project friday
 * @Package com.lmy.friday.dto
 * @author Administrator
 * @date 2020/6/28 22:11
 * @version V1.0
 */

import com.lmy.friday.entity.SysRole;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 * @ClassName RoleDTO
 * @Description 角色新增接收参数接口
 * @date 2020/6/28 22:11
 **/
@Data
public class RoleDTO extends SysRole {

    // 权限id集合
    private List<Integer> permissionIds;

}
