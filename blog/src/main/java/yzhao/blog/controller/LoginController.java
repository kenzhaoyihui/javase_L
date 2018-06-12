package yzhao.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import yzhao.blog.service.AdminLoginLogService;
import yzhao.blog.service.AdminService;
import yzhao.blog.service.impls.AdminLoginLogServiceImpl;
import yzhao.blog.service.impls.AdminServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

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


    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("spring.xml");

        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        buf.clear();
        buf.flip()
    }





}
