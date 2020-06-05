package com.cp.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//登入界面的跳转
@Controller
@RequestMapping("/sys")
public class SystemController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "sys/index/login";
    }

    @RequestMapping("/index")
    public String index(){
        return "sys/index/index";
    }

    @RequestMapping("/Main")
    public String Main(){
        return "sys/index/deskManager";
    }

//    跳转日志管理
    @RequestMapping("/toLogInfoManager")
    public String toLogInfoManager(){
        return "sys/loginfo/loginfoManager";
    }
}
