package com.example.item.controller;

import com.example.item.po.SysUser;
import com.example.item.service.SysUserService;
import com.example.item.utils.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "all",method = RequestMethod.GET)
    @ResponseBody
    public Msg getAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,5);
        List<SysUser> users = sysUserService.getAll();
        PageInfo pageInfo = new PageInfo(users);
        return Msg.success().add("all",pageInfo);
    }

    @RequestMapping(value = "getDetail",method = RequestMethod.GET)
    @ResponseBody
    public Msg getDetail(Integer userId){
        SysUser user = sysUserService.detail(userId);
        if (user!=null){
            return Msg.success().add("detail",user);
        }
        return Msg.fail().add("msg","没有该用户");
    }

}
