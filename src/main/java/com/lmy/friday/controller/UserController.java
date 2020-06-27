package com.lmy.friday.controller;
/**
 * @Project friday
 * @Package com.lmy.friday.controller
 * @author Administrator
 * @date 2020/6/25 18:18
 * @version V1.0
 */

import com.lmy.friday.entity.SysUser;
import com.lmy.friday.service.SysUserService;
import com.lmy.friday.vo.PageTableRequest;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @ClassName UserController
 * @Description 用户管理控制器
 * @date 2020/6/25 18:18
 **/
@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private SysUserService sysUserServiceImpl;


    @GetMapping("list")
    @ResponseBody
    public Results<SysUser> getUsersByPage(PageTableRequest ptr) {
       log.info("【用户控制器】查询所有用户!");
       // 计算offset
       ptr.countOffset();
       // 查询
       return sysUserServiceImpl.selectUserByPage(ptr.getOffset(), ptr.getLimit(), ptr.getSearch());
    }

//    @GetMapping("showAdd")
//    public String showAdd(Model model) {
//        log.info("【用户控制器】跳转新增页面");
//        model.addAttribute(new SysUser());
//        return "user/user-add";
//    }





}
