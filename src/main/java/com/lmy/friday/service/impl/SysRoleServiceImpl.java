package com.lmy.friday.service.impl;
/**
 * @Project friday
 * @Package com.lmy.friday.service.impl
 * @author Administrator
 * @date 2020/6/26 16:28
 * @version V1.0
 */

import com.lmy.friday.dto.RoleDTO;
import com.lmy.friday.entity.SysRole;
import com.lmy.friday.entity.SysUser;
import com.lmy.friday.mapper.SysRoleMapper;
import com.lmy.friday.mapper.SysRolePermissionMapper;
import com.lmy.friday.service.SysRoleService;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @ClassName SysRoleServiceImpl
 * @Description 角色业务层
 * @date 2020/6/26 16:28
 **/
@Slf4j
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public Results<SysRole> getAllRole() {
        log.info("【角色业务层】查询所有角色");
        List<SysRole> roles = sysRoleMapper.selectAllRole();
        return Results.success((long) roles.size(), roles);
    }

    /**
     * 分页查询角色
     * @param offset
     * @param limit
     * @param search
     * @return
     */
    @Override
    public Results<SysRole> getRoleByPage(Integer offset, Integer limit, String search) {
        log.info("【角色业务层】 开始查询角色");
        // 查询总数
        if (StringUtils.isBlank(search)) {
            search = null;
        }
        Long count = sysRoleMapper.rolesCount(search);
        // 查询当前页的用户数据
        List<SysRole> roles = sysRoleMapper.getRoleByPage(offset, limit, search);
        log.info("【用户业务层】 查询所有用户成功");
        return Results.success(count, roles);
    }

    @Override
    @Transactional
    public Results<Void> saveRole(RoleDTO roleDTO) {
        // 新增角色表
        SysRole role = new SysRole();
        BeanUtils.copyProperties(roleDTO, role);
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        sysRoleMapper.insertRole(role);
        // 新增角色权限关联
        List<Integer> ids = roleDTO.getPermissionIds();
        if (!CollectionUtils.isEmpty(ids)) {
            ids.remove(0);
            sysRolePermissionMapper.insert(role.getId(), ids);
        } else {
            return Results.failure();
        }

        return Results.success();
    }


}
