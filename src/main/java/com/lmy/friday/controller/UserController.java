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
import com.lmy.friday.utils.MD5;
import com.lmy.friday.vo.PageTableRequest;
import com.lmy.friday.vo.ResponseCode;
import com.lmy.friday.vo.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 用户分页查询
     * @param ptr
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public Results<SysUser> getUsersByPage(PageTableRequest ptr) {
       log.info("【用户控制器】查询所有用户!");
       // 计算offset
       ptr.countOffset();
       // 查询
       return sysUserServiceImpl.selectUserByPage(ptr.getOffset(), ptr.getLimit(), ptr.getSearch());
    }


    /**
     * 显示新增用户界面
     * @param model
     * @return
     */
    @GetMapping("showAdd")
    public String showAdd(Model model) {
        log.info("【用户控制器】跳转新增页面");
        model.addAttribute(new SysUser());
        return "user/user-add";
    }

    /**
     * 用户新增
     * @param user
     * @param roleId
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public Results<Void> addUser(SysUser user, Integer roleId) {
        // 参数
        SysUser sysUser = null;
        // 验证用户名
        sysUser = sysUserServiceImpl.getUserByUsername(user.getUsername());
        if(sysUser != null && !(sysUser.getId().equals(user.getId()))){
            log.info("用户名已经存在");
            return Results.failure(ResponseCode.USERNAME_REPEAT.getCode(),ResponseCode.USERNAME_REPEAT.getMessage());
        }
        // 验证手机号
        sysUser = sysUserServiceImpl.getUserByTelephone(user.getTelephone());
        if(sysUser != null && !(sysUser.getId().equals(user.getId()))){
            log.info("手机号已经存在");
            return Results.failure(ResponseCode.PHONE_REPEAT.getCode(),ResponseCode.PHONE_REPEAT.getMessage());
        }
        // 验证邮箱
        sysUser = sysUserServiceImpl.getUserByEmail(user.getEmail());
        if(sysUser != null && !(sysUser.getId().equals(user.getId()))){
            log.info("邮箱已经存在");
            return Results.failure(ResponseCode.EMAIL_REPEAT.getCode(),ResponseCode.EMAIL_REPEAT.getMessage());
        }
        log.info("参数无误，开始新增");
        user.setStatus(1);
        user.setPassword(MD5.crypt(user.getPassword()));
        return sysUserServiceImpl.save(user, roleId);
    }

    /**
     * 显示修改界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("edit")
    public String showEdit(Integer id, Model model) {
        log.info("显示用户编辑界面");
        SysUser user = sysUserServiceImpl.getUserById(id);
        model.addAttribute("sysUser", user);
        return "user/user-edit";
    }

    /**
     * 用户修改
     * @param user
     * @param roleId
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public Results<Void> editUser(SysUser user, Integer roleId) {
        SysUser sysUser = null;
        sysUser = sysUserServiceImpl.getUserByUsername(user.getUsername());
        if(sysUser != null && !(sysUser.getId().equals(user.getId()))){
            return Results.failure(ResponseCode.USERNAME_REPEAT.getCode(),ResponseCode.USERNAME_REPEAT.getMessage());
        }
        sysUser = sysUserServiceImpl.getUserByTelephone(user.getTelephone());
        if(sysUser != null && !(sysUser.getId().equals(user.getId()))){
            return Results.failure(ResponseCode.PHONE_REPEAT.getCode(),ResponseCode.PHONE_REPEAT.getMessage());
        }
        sysUser = sysUserServiceImpl.getUserByEmail(user.getEmail());
        if(sysUser != null && !(sysUser.getId().equals(user.getId()))){
            return Results.failure(ResponseCode.EMAIL_REPEAT.getCode(),ResponseCode.EMAIL_REPEAT.getMessage());
        }
        return sysUserServiceImpl.updateUser(user,roleId);
    }


    @GetMapping("delete")
    @ResponseBody
    public Results<Void> deleteUser(Integer id) {
        log.info("执行删除控制器");
        return sysUserServiceImpl.deleteUser(id);
    }

}
