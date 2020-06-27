package com.lmy.friday.service.impl;
/**
 * @Project friday
 * @Package com.lmy.friday.service.impl
 * @author Administrator
 * @date 2020/6/26 16:28
 * @version V1.0
 */

import com.lmy.friday.entity.SysRole;
import com.lmy.friday.mapper.SysRoleMapper;
import com.lmy.friday.service.SysRoleService;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public Results<SysRole> getAllRole() {
        log.info("【角色业务层】查询所有角色");
        List<SysRole> roles = sysRoleMapper.selectAllRole();
        return Results.success((long) roles.size(), roles);
    }
}
