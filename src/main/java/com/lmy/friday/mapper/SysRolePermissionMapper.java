package com.lmy.friday.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Project friday
 * @Package com.lmy.friday.mapper
 * @author Administrator
 * @date 2020/6/28 22:28
 * @version V1.0
 */
@Mapper
public interface SysRolePermissionMapper {

    Integer insert(Integer roleId, List<Integer> ids);

    @Delete("delete from sys_role_permission where roleId = #{id}")
    Integer deleteByRoleId(@Param("id") Integer id);

    @Delete("delete from sys_role_permission where permissionId = #{permissionId}")
    Integer deleteByPermissionId(@Param("permissionId") Integer permissionId);
}
