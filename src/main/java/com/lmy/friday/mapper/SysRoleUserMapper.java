package com.lmy.friday.mapper;

import com.lmy.friday.entity.SysRoleUser;
import org.apache.ibatis.annotations.*;

/**
 * @author Administrator
 * @version V1.0
 * @Project friday
 * @Package com.lmy.friday.mapper
 * @date 2020/6/27 17:04
 */
@Mapper
public interface SysRoleUserMapper {

    Integer insertRoleUser(SysRoleUser roleUser);

    @Select("select * from sys_role_user where userId = #{userId}")
    SysRoleUser selectByUserId(@Param("userId") Integer userId);

    @Update("update sys_role_user set roleId = #{roleId} where userId = #{userId}")
    Integer update(SysRoleUser roleUser);

    @Delete("delete from sys_role_user where userId = #{userId}")
    Integer deleteRoleUser(@Param("userId") Integer userId);

    @Delete("delete from sys_role_user where roleId = #{roleId}")
    Integer deleteByRoleId(@Param("roleId") Integer roleId);
}
