package com.lmy.friday.service.impl;


import com.lmy.friday.entity.SysUser;
import com.lmy.friday.mapper.SysUserMapper;
import com.lmy.friday.service.SysUserService;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}