package com.example.controller;

import com.example.bean.SystemUser;
import com.example.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;

    @RequestMapping("/login")
    public String adminLoginDo(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        SystemUser systemUser = systemUserService.findUserByUsername(username);

        if (null == systemUser) {
            map.put("loginResult", "User is not exist");
            return "login";
        }else if (!password.equals(systemUser.getPassword())){
            map.put("loginResult", "Password error");
            return "login";
        }else {
            return "index";
        }
    }
}
