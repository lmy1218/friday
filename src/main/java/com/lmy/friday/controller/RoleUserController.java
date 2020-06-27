package com.lmy.friday.controller;
/**
 * @Project friday
 * @Package com.lmy.friday.controller
 * @author Administrator
 * @date 2020/6/27 18:43
 * @version V1.0
 */

import com.lmy.friday.entity.SysRoleUser;
import com.lmy.friday.service.SysRoleUserService;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @ClassName RoleUserController
 * @Description 用户角色关联控制器
 * @date 2020/6/27 18:43
 **/
@Slf4j
@Controller
@RequestMapping("roleuser")
public class RoleUserController {

    @Autowired
    private SysRoleUserService sysRoleUserServiceImpl;


    @GetMapping("getRoleUserByUserId")
    @ResponseBody
    public Results<SysRoleUser> getRoleUserByUserId(Integer userId) {
        log.info("查询用户角色关联");
        return sysRoleUserServiceImpl.selectByUserId(userId);
    }



}
