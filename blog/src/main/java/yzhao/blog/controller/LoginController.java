package yzhao.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import yzhao.blog.bean.AdminLoginLog;
import yzhao.blog.service.AdminLoginLogService;
import yzhao.blog.service.AdminService;
import yzhao.blog.service.impls.AdminLoginLogServiceImpl;
import yzhao.blog.service.impls.AdminServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.HashMap;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    @Autowired
    AdminLoginLogService adminLoginLogService;


    @RequestMapping(value = {"/admin/index", "/admin", "/admin/login"})
    public String toIndex(HttpServletRequest request){
        return "admin/login";
    }

    /**
     * 0: user is not exist
     * 1: password is error
     * 2: Login successfully , then turning to the next page
     */

    @RequestMapping(value = "/api/loginCheck", method = RequestMethod.POST)
    @ResponseBody
    public Object loginCheck(HttpServletRequest request, HttpServletResponse response){

        int id = Integer.parseInt(request.getParameter("id"));
        String passwd = request.getParameter("password");

        HashMap<String, String> map = new HashMap<>();

        if (adminService.getAdminById(id) == null){
            map.put("stateCode", "0");
        }else if (!adminService.getAdminById(id).getPassword().equals(passwd)){
            map.put("stateCode", "1");
        }else{
            String ip = request.getRemoteAddr();
            AdminLoginLog adminLoginLog = new AdminLoginLog();
            adminLoginLog.setAdminId(id);
            adminLoginLog.setDate(new Date());
            adminLoginLog.setIp(ip);

            int log = adminLoginLogService.insert(adminLoginLog);

            Cookie cookie = new Cookie("userId", ""+id );
            cookie.setMaxAge(3600*24);

            response.addCookie(cookie);
            request.getSession().setAttribute("admin", adminService.getAdminById(id));

            map.put("stateCode", "2");

        }
        return  map;
    }

    @RequestMapping(value = "/admin/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("admin");
        return "redirect:/admin";
    }
}
