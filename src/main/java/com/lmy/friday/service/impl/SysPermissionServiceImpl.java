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
import com.lmy.friday.mapper.SysRolePermissionMapper;
import com.lmy.friday.service.SysPermissionService;
import com.lmy.friday.utils.TreeUtils;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 获取所有权限菜单
     * @return
     */
    @Override
    public Results<JSONArray> getAllPermission() {
        // 查询所有权限
        List<SysPermission> list = sysPermissionMapper.selectAll();
        // 组装返回值
        JSONArray array = new JSONArray();
        TreeUtils.setPermissionsTree(0, list, array);
        return Results.success(array);
    }

    @Override
    public Results<SysPermission> getAllPermissionByRoleId(Integer id) {
        // 根据roleId查询
        List<SysPermission> list = sysPermissionMapper.selectPermissionByRole(id);
        if (CollectionUtils.isEmpty(list)) {
            return Results.failure();
        }
        return Results.success((long)list.size() , list);
    }

    @Override
    public Results<SysPermission> getAllMenu() {
        List<SysPermission> list = sysPermissionMapper.selectAll();
        return Results.success((long)list.size(), list);
    }

    @Override
    @Transactional
    public Results<Void> save(SysPermission permission) {
        return sysPermissionMapper.insert(permission) > 0 ? Results.success() : Results.failure();
    }

    @Override
    public SysPermission getById(Integer id) {
        return sysPermissionMapper.selectById(id);
    }

    @Override
    @Transactional
    public Results<Void> edit(SysPermission sysPermission) {
        return sysPermissionMapper.update(sysPermission) > 0 ? Results.success() : Results.failure();
    }

    @Override
    @Transactional
    public Results<Void> delete(Integer id) {
        // 删除权限角色关联数据
        sysRolePermissionMapper.deleteByPermissionId(id);
        // 删除权限
        sysPermissionMapper.delete(id);
        return Results.success();
    }

    @Override
    public Results getMenu(Integer userId) {
        List<SysPermission> datas = sysPermissionMapper.selectByUserId(userId);
        datas = datas.stream().filter(p -> p.getType().equals(1)).collect(Collectors.toList());
        JSONArray array = new JSONArray();
        log.info(getClass().getName() + ".setPermissionsTree(?,?,?)");
        TreeUtils.setPermissionsTree(0, datas, array);
        return Results.success(array);
    }


}
