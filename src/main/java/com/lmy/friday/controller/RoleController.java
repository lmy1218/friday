package com.lmy.friday.controller;
/**
 * @Project friday
 * @Package com.lmy.friday.controller
 * @author Administrator
 * @date 2020/6/26 16:23
 * @version V1.0
 */

import com.lmy.friday.entity.SysRole;
import com.lmy.friday.service.SysRoleService;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lmy
 * @ClassName RoleController
 * @Description 角色管理控制器
 * @date 2020/6/26 16:23
 **/
@Slf4j
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private SysRoleService sysRoleServiceImpl;

    @GetMapping("all")
    @ResponseBody
    public Results<SysRole> getAllRole() {
        log.info("【角色控制器】执行查询所有角色");
        return sysRoleServiceImpl.getAllRole();
    }


}
