package com.lmy.friday.service.impl;


import com.lmy.friday.entity.SysRoleUser;
import com.lmy.friday.entity.SysUser;
import com.lmy.friday.mapper.SysRoleUserMapper;
import com.lmy.friday.mapper.SysUserMapper;
import com.lmy.friday.service.SysUserService;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-25 17:45:06
 */
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;


    /**
     * 查询所有用户信息
     * @return
     * @param offset 起始位置
     * @param limit 每页大小
     * @param search
     */
    @Override
    public Results<SysUser> selectUserByPage(Integer offset, Integer limit, String search) {
        log.info("【用户业务层】 开始查询所有用户");
        // 查询总数
        if (StringUtils.isBlank(search)) {
            search = null;
        }
        Long count = sysUserMapper.usersCount(search);
        // 查询当前页的用户数据
        List<SysUser> users = sysUserMapper.getUserByPage(offset, limit, search);
        log.info("【用户业务层】 查询所有用户成功");
        return Results.success(count, users);
    }


    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @Override
    public SysUser getUserByUsername(String username) {
        return sysUserMapper.selcetUserByUsername(username);
    }

    /**
     * 根据手机号查询
     * @param telephone
     * @return
     */
    @Override
    public SysUser getUserByTelephone(String telephone) {
        return sysUserMapper.selcetUserByTelephone(telephone);
    }

    /**
     * 根据邮箱查询
     * @param email
     * @return
     */
    @Override
    public SysUser getUserByEmail(String email) {
        return sysUserMapper.selcetUserByEmail(email);
    }

    /**
     * 保存用户
     * @param user
     * @param roleId
     * @return
     */
    @Override
    @Transactional
    public Results<Void> save(SysUser user, Integer roleId) {
        if (roleId != null) {
            // 新增用户
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            sysUserMapper.insertUser(user);
            // 新增用户与角色关联
            SysRoleUser roleUser = new SysRoleUser();
            roleUser.setRoleId(roleId);
            roleUser.setUserId(user.getId());
            sysRoleUserMapper.insertRoleUser(roleUser);
            return Results.success();
        } else {
            log.error("角色ID为空");
            return Results.failure();
        }
    }

    /**
     * 根据id 查询
     * @param id
     * @return
     */
    @Override
    public SysUser getUserById(Integer id) {
        return sysUserMapper.selectUserById(id);
    }

    @Override
    @Transactional
    public Results<Void> updateUser(SysUser user, Integer roleId) {
        if (roleId != null) {
            user.setUpdateTime(new Date());
            sysUserMapper.updateUser(user);
            SysRoleUser roleUser = new SysRoleUser();
            roleUser.setRoleId(roleId);
            roleUser.setUserId(user.getId());
            SysRoleUser byUserId = sysRoleUserMapper.selectByUserId(user.getId());
            if (byUserId == null) {
                sysRoleUserMapper.insertRoleUser(roleUser);
            } else {
                sysRoleUserMapper.update(roleUser);
            }
            log.info("用户修改成功");
            return Results.success();
        } else {
            log.info("用户修改失败，角色id为空");
            return Results.failure();
        }
    }

    @Override
    @Transactional
    public Results<Void> deleteUser(Integer id) {
        // 删除关联表
        sysRoleUserMapper.deleteRoleUser(id);
        // 删除用户表记录
        Integer index = sysUserMapper.deleteUser(id);
        if (index == 1) {
            return Results.success();
        } else {
            return Results.failure();
        }
    }


}