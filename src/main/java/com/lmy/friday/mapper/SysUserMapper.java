package com.lmy.friday.mapper;

import com.lmy.friday.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

}
