package com.lmy.friday.mapper;

import com.lmy.friday.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @version V1.0
 * @Project friday
 * @Package com.lmy.friday.mapper
 * @date 2020/6/26 16:29
 */
@Mapper
public interface SysRoleMapper {

    List<SysRole> selectAllRole();

    Long rolesCount(String search);

    List<SysRole> getRoleByPage(Integer offset, Integer limit, String search);

    Integer insertRole(SysRole sysRole);
}
