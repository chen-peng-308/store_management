package com.cp.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cp.sys.bean.Loginfo;
import com.cp.sys.common.DataGridViem;
import com.cp.sys.service.LoginfoService;
import com.cp.sys.vo.LoginfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cp
 * @since 2020-06-02
 */
@RestController
@RequestMapping("/loginfo")
public class LoginfoController {
    @Autowired
    private LoginfoService loginfoService;

    @RequestMapping("/loadAllLoginfo")
    public DataGridViem loadAllLoginfo(LoginfoVo loginfoVo){
        IPage<Loginfo> page=new Page<>(loginfoVo.getPaeg(),loginfoVo.getLimit());
        QueryWrapper<Loginfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginname()),"loginname",loginfoVo.getLoginname());
        queryWrapper.like(StringUtils.isNotBlank(loginfoVo.getLoginip()),"loginip",loginfoVo.getLoginip());
        queryWrapper.ge(loginfoVo.getStartTime()!=null,"logintime",loginfoVo.getEndTime());
        queryWrapper.like(loginfoVo.getEndTime()!=null,"logintime",loginfoVo.getEndTime());
        this.loginfoService.page(page,queryWrapper);
        return new DataGridViem(page.getTotal(),page.getRecords());
    }
}

