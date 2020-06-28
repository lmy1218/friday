package com.lmy.friday.controller;
/**
 * @Project friday
 * @Package com.lmy.friday.controller
 * @author Administrator
 * @date 2020/6/28 21:43
 * @version V1.0
 */

import com.alibaba.fastjson.JSONArray;
import com.lmy.friday.service.SysPermissionService;
import com.lmy.friday.vo.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Results<JSONArray> listAllPermission() {
        return sysPermissionServiceImpl.getAllPermission();
    }


}
