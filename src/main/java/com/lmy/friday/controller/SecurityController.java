package com.lmy.friday.controller;
/**
 * @Project friday
 * @Package com.lmy.friday.controller
 * @author Administrator
 * @date 2020/6/30 20:53
 * @version V1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Administrator
 * @ClassName SecurityController
 * @Description Security控制器
 * @date 2020/6/30 20:53
 **/
@Controller
public class SecurityController {

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/403.html")
    public String noPermission() {
        return "403";
    }

}
