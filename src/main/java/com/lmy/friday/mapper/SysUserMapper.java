package com.lmy.friday.mapper;

import com.lmy.friday.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project friday
 * @Package com.lmy.friday.mapper
 * @date 2020/6/25 18:13
 */
@Mapper
public interface SysUserMapper {

    // 查询用户数
    Long usersCount(@Param("search") String search);

    // 分页查询
    List<SysUser> getUserByPage(@Param("offset") Integer offset, @Param("limit") Integer limit, @Param("search") String search);

    SysUser selcetUserByUsername(@Param("username") String username);

    SysUser selcetUserByTelephone(String telephone);

    SysUser selcetUserByEmail(String email);

    Integer insertUser(SysUser user);

    @Select("select * from sys_user where id = #{id}")
    SysUser selectUserById(@Param("id") Integer id);

    Integer updateUser(SysUser user);

    @Delete("delete from sys_user where id = #{id}")
    Integer deleteUser(@Param("id") Integer id);

    @Update("update sys_user set password = #{password} where id = #{id}")
    Integer update(Integer id, String password);
}
