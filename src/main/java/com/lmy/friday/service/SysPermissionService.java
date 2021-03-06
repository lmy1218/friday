package com.lmy.friday.service;

import com.alibaba.fastjson.JSONArray;
import com.lmy.friday.entity.SysPermission;
import com.lmy.friday.vo.Results;

/**
 * @Project friday
 * @Package com.lmy.friday.service
 * @author Administrator
 * @date 2020/6/28 21:46
 * @version V1.0
 */

public interface SysPermissionService {

    Results<JSONArray> getAllPermission();

    Results<SysPermission> getAllPermissionByRoleId(Integer id);

    Results<SysPermission> getAllMenu();

    Results<Void> save(SysPermission permission);

    SysPermission getById(Integer id);

    Results<Void> edit(SysPermission sysPermission);

    Results<Void> delete(Integer id);

    Results<SysPermission> getMenu(Integer userId);
}
