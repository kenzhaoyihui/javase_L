package yzhao.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import yzhao.blog.bean.Article;
import yzhao.blog.service.ArticleService;
import yzhao.blog.service.CommentService;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    CommentService commentService;

    @Autowired
    ArticleService articleService;

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(required = true, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "5") Integer pageSize){

        ModelAndView modelAndView = new ModelAndView("index");

        PageHelper.startPage(page, pageSize);
        List<Article> articles = articleService.queryAll();

        //PageInfo<Article> pageInfo = new PageInfo<>(articles);
        PageInfo pageInfo = new PageInfo(articles);

        modelAndView.addObject("articles", articles);
        modelAndView.addObject("pageInfo", pageInfo);

        return modelAndView;
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
