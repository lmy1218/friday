package com.lmy.friday.mapper;

import com.lmy.friday.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lmy
 * @version V1.0
 * @Project friday
 * @Package com.lmy.friday.mapper
 * @date 2020/6/28 21:45
 */
@Mapper
public interface SysPermissionMapper {

    @Select("select * from sys_permission")
    List<SysPermission> selectAll();

    @Select("select p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId where rp.roleId = #{roleId} order by p.sort")
    List<SysPermission> selectPermissionByRole(@Param("roleId") Integer roleId);
}
