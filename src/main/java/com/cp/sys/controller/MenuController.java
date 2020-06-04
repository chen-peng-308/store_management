package com.cp.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cp.sys.bean.Permission;
import com.cp.sys.bean.User;
import com.cp.sys.common.*;
import com.cp.sys.service.PermissionService;
import com.cp.sys.vo.PermissionVo;
import lombok.AllArgsConstructor;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//菜单列表
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/MenuJson")
    public DataGridViem MenuJson(PermissionVo permissionVo){
        QueryWrapper<Permission> queryWrapper=new QueryWrapper<>();
//        设置查询菜单
        queryWrapper.eq("type",Constast.TYPE_MENU);
//        状态为可用
        queryWrapper.eq("available",Constast.AVAILABLE_TRUE);
        User user= (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list=null;
        if(user.getType()==Constast.USER_TYPE_SUPER){
//            用户类型为超级管理员
            list=permissionService.list(queryWrapper);
        }else {
//            普通用户
            list=permissionService.list(queryWrapper);
        }
        List<TreeNode> treeNodes=new ArrayList<>();
        for (Permission permission:list) {
            Integer id=permission.getId();
            Integer pid=permission.getPid();
            String title=permission.getTitle();
            String icon=permission.getIcon();
            String href=permission.getHref();
            Boolean spread=permission.getOpen()==Constast.OPEN_TRUE?true:false;
            treeNodes.add(new TreeNode(id,pid,title,icon,href,spread));
        }
        List<TreeNode> list1=TreeNodeBuilder.build(treeNodes,1);
        return new DataGridViem(list1);
    }
}
