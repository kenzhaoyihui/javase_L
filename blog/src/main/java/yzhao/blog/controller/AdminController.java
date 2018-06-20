package yzhao.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yzhao.blog.bean.Admin;
import yzhao.blog.bean.AdminLoginLog;
import yzhao.blog.service.AdminLoginLogService;
import yzhao.blog.service.AdminService;
import yzhao.blog.service.ArticleService;
import yzhao.blog.service.CommentService;
import yzhao.blog.service.impls.AdminLoginLogServiceImpl;
import yzhao.blog.service.impls.ArticleServiceImpl;
import yzhao.blog.service.impls.CommentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminLoginLogService adminLoginLogService;

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;

    @RequestMapping("/main")
    public ModelAndView toMain(HttpServletRequest request) {
        //ModelAndView modelAndView = new ModelAndView("/admin/main");
        String clientIp = request.getRemoteAddr();
        String hostIp = request.getLocalAddr();
        int hostPort = request.getLocalPort();
        Date date = new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String dates = df.format(date);

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        AdminLoginLog lastLoginLog = null;

        try{
            if (adminLoginLogService.selectRencent(admin.getId()) != null && adminLoginLogService.selectRencent(admin.getId()).size()==2){
                List<AdminLoginLog> adminLoginLogs = adminLoginLogService.selectRencent(admin.getId());
                lastLoginLog = adminLoginLogs.get(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            int articleCount = articleService.selectCount();
            int commentCount = commentService.countAllNum();
            int loginNum = adminLoginLogService.selectCountByAdminId(admin.getId());

            Map<String, Object> model = new HashMap<>();

            model.put("clientIp", clientIp);
            model.put("hostIp", hostIp);
            model.put("hostPort", hostPort);
            model.put("date", dates);

            if (lastLoginLog != null){
                model.put("loginLog", lastLoginLog);
            }

            model.put("articleCount", articleCount);
            model.put("commentCount", commentCount);
            model.put("loginNum", loginNum);

            ModelAndView modelAndView = new ModelAndView("admin/main", model);



//            modelAndView.addObject("clientIp", clientIp);
//            modelAndView.addObject("hostIp", hostIp);
//            modelAndView.addObject("hostPort", hostPort);
//            modelAndView.addObject("date", dates);
//
//            if (lastLoginLog != null){
//                modelAndView.addObject("loginLog", lastLoginLog);
//            }
//
//            modelAndView.addObject("articleCount", articleCount);
//            modelAndView.addObject("commentCount", commentCount);
//            modelAndView.addObject("loginNum", loginNum);


            return modelAndView;
        }

    }


}
