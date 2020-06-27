package com.lmy.friday.service;

import com.lmy.friday.entity.SysUser;
import com.lmy.friday.vo.Results;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-25 17:45:06
 */
public interface SysUserService {

    // 查询所有用户信息
    Results<SysUser> selectUserByPage(Integer offset, Integer limit, String search);
}