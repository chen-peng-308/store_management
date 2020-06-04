package com.cp.sys.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cp.sys.bean.User;
import com.cp.sys.common.ActiverUser;
import com.cp.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
//    登入认证

    @Autowired
    private UserService userService;


    @Override
    public String getName() {//获取用户
        return this.getClass().getSimpleName();
    }


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("loginname", authenticationToken.getPrincipal().toString());
        User user=userService.getOne(queryWrapper);
        if(null!=user){
            ActiverUser activerUser=new ActiverUser();
            activerUser.setUser(user);
            ByteSource byteSource=ByteSource.Util.bytes(user.getSalt());//获取加密方式
            SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(activerUser,user.getPwd(),byteSource,this.getName());//密码验证
            return info;
        }
        return null;
    }
}
