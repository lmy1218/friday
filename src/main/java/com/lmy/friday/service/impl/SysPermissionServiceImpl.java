package com.lmy.friday.service.impl;
/**
 * @Project friday
 * @Package com.lmy.friday.service.impl
 * @author Administrator
 * @date 2020/6/28 21:46
 * @version V1.0
 */

import com.alibaba.fastjson.JSONArray;
import com.lmy.friday.entity.SysPermission;
import com.lmy.friday.mapper.SysPermissionMapper;
import com.lmy.friday.service.SysPermissionService;
import com.lmy.friday.utils.TreeUtils;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @ClassName SysPermissionServiceImpl
 * @Description 权限业务层
 * @date 2020/6/28 21:46
 **/
@Slf4j
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;


    @Override
    public Results<JSONArray> getAllPermission() {
        // 查询所有权限
        List<SysPermission> list = sysPermissionMapper.selectAll();
        // 组装返回值
        JSONArray array = new JSONArray();
        TreeUtils.setPermissionsTree(0, list, array);
        return Results.success(array);
    }
}
