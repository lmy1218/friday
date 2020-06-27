package com.lmy.friday.service;

import com.lmy.friday.entity.SysRoleUser;
import com.lmy.friday.vo.Results;

/**
 * @author Administrator
 * @version V1.0
 * @Project friday
 * @Package com.lmy.friday.service
 * @date 2020/6/27 18:44
 */
public interface SysRoleUserService {

    Results<SysRoleUser> selectByUserId(Integer userId);
}
