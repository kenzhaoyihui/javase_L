package yzhao.blog.controller;


import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import yzhao.blog.bean.Comment;
import yzhao.blog.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/api/comment/add", method = RequestMethod.POST)
    public Object commentAdd(HttpServletRequest request) {
        Comment comment = new Comment();
        comment.setArticleId(Long.parseLong(request.getParameter("articleId")));
        comment.setContent(request.getParameter("content"));
        comment.setDate(new Date());
        comment.setName(request.getParameter("name"));
        comment.setEmail(request.getParameter("email"));

        HashMap<String, String> map = new HashMap<>();
        if (commentService.insertComment(comment) > 0) {
            map.put("stateCode", "1");
        }else {
            map.put("stateCode", "0");
        }

        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/api/comment/del", method = RequestMethod.POST)
    public Object commentDel(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        HashMap<String, String> map = new HashMap<>();

        if (commentService.delById(id)) {
            map.put("stateCode", "1");
        }else {
            map.put("stateCode", "0");
        }

        return map;
    }
}
