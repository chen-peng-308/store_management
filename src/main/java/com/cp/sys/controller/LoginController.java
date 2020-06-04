package com.cp.sys.controller;

import com.cp.sys.common.ActiverUser;
import com.cp.sys.common.ResultObj;
import com.cp.sys.common.WebUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
//    登入验证
    @RequestMapping("/Enter")
    public ResultObj Enter(String userName,String password){
        Subject subject=SecurityUtils.getSubject();
        AuthenticationToken token=new UsernamePasswordToken(userName,password);
        try {
            subject.login(token);
            ActiverUser activerUser= (ActiverUser) subject.getPrincipal();
            WebUtils.getSession().setAttribute("user",activerUser.getUser());
            return ResultObj.LOGIN_SUCCESS;
        }catch (AuthenticationException e){
            return ResultObj.LOGIN_ERORR_PASS;
        }


    }
}
