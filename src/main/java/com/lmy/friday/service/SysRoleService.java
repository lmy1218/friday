package com.lmy.friday.service;

import com.lmy.friday.entity.SysRole;
import com.lmy.friday.vo.Results;

/**
 * @author Administrator
 * @version V1.0
 * @Project friday
 * @Package com.lmy.friday.service
 * @date 2020/6/26 16:27
 */
public interface SysRoleService {
    Results<SysRole> getAllRole();
}
