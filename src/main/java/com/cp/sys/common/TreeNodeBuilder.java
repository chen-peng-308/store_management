package com.cp.sys.common;

import java.util.ArrayList;
import java.util.List;

//左边菜单列出二级菜单
public class TreeNodeBuilder {
    public static List<TreeNode> build(List<TreeNode> treeNodes,Integer topid){
        List<TreeNode> list=new ArrayList<>();
        for (TreeNode treeNode:treeNodes) {
            if(treeNode.getPid()==topid){
                list.add(treeNode);
            }
            for (TreeNode treeNode1:treeNodes) {
                if (treeNode.getId()==treeNode1.getPid()){
                    treeNode.getChildren().add(treeNode1);
                }
            }
        }
        return list;
    }
}
