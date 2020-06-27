package com.lmy.friday.controller;
/**
 * @Project friday
 * @Package com.lmy.friday.controller
 * @author Administrator
 * @date 2020/6/25 17:12
 * @version V1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @ClassName ApiController
 * @Description TODO
 * @date 2020/6/25 17:12
 **/
@Controller
@RequestMapping("${api-url}")
public class ApiController {


    @GetMapping("/getPage")
    public String getPage(String pageName) {
        return pageName;
    }


}
