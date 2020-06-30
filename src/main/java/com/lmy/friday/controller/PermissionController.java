package com.lmy.friday.controller;
/**
 * @Project friday
 * @Package com.lmy.friday.controller
 * @author Administrator
 * @date 2020/6/28 21:43
 * @version V1.0
 */

import com.alibaba.fastjson.JSONArray;
import com.lmy.friday.entity.SysPermission;
import com.lmy.friday.service.SysPermissionService;
import com.lmy.friday.vo.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @ClassName PermissionController
 * @Description 权限控制器
 * @date 2020/6/28 21:43
 **/
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private SysPermissionService sysPermissionServiceImpl;

    /**
     * 查询所有权限
     * @return
     */
    @GetMapping("listAllPermission")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public Results<JSONArray> listAllPermission() {
        return sysPermissionServiceImpl.getAllPermission();
    }

    /**
     * 根据角色查询权限
     * @param id
     * @return
     */
    @GetMapping("listAllPermissionByRoleId")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public Results<SysPermission> listAllPermissionByRoleId(Integer id) {
        return sysPermissionServiceImpl.getAllPermissionByRoleId(id);
    }

    /**
     * 查询所有菜单
     * @return
     */
    @GetMapping("menuAll")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:menu:query')")
    public Results<SysPermission> getAllMenu() {
        return sysPermissionServiceImpl.getAllMenu();
    }


    /**
     * 显示添加页面
     * @param model
     * @return
     */
    @GetMapping("add")
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public String showAdd(Model model) {
        model.addAttribute("sysPermission", new SysPermission());
        return "permission/permission-add";
    }

    /**
     * 新增保存
     * @param permission
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public Results<Void> addPermission(@RequestBody SysPermission permission) {
        return sysPermissionServiceImpl.save(permission);
    }

    /**
     * 显示编辑页面
     * @param model
     * @param id
     * @return
     */
    @GetMapping("edit")
    @PreAuthorize("hasAuthority('sys:menu:edit')")
    public String showEdit(Model model, Integer id) {
        model.addAttribute("sysPermission", sysPermissionServiceImpl.getById(id));
        return "permission/permission-add";
    }

    /**
     * 保存修改
     * @param sysPermission
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:menu:edit')")
    public Results<Void> edit(@RequestBody SysPermission sysPermission) {
        return sysPermissionServiceImpl.edit(sysPermission);
    }

    @GetMapping("delete")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:menu:del')")
    public Results<Void> delete(Integer id) {
        return sysPermissionServiceImpl.delete(id);
    }


    @GetMapping("menu")
    @ResponseBody
    public Results<SysPermission> getMenu(Integer userId) {
        return sysPermissionServiceImpl.getMenu(userId);
    }



}
