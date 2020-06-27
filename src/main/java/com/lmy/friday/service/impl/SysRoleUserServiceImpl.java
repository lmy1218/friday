package com.lmy.friday.service.impl;
/**
 * @Project friday
 * @Package com.lmy.friday.service.impl
 * @author Administrator
 * @date 2020/6/27 18:45
 * @version V1.0
 */

import com.lmy.friday.entity.SysRoleUser;
import com.lmy.friday.mapper.SysRoleUserMapper;
import com.lmy.friday.service.SysRoleUserService;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @ClassName SysRoleUserServiceImpl
 * @Description 用户角色关联控制器
 * @date 2020/6/27 18:45
 **/
@Slf4j
@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public Results<SysRoleUser> selectByUserId(Integer userId) {
        SysRoleUser roleUser = sysRoleUserMapper.selectByUserId(userId);
        if (roleUser != null) {
            return Results.success(roleUser);
        }
        return Results.failure();
    }
}
