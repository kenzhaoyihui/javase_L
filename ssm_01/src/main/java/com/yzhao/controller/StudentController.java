package com.yzhao.controller;

import com.yzhao.pojo.Studnet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView student(){
        return new ModelAndView("student", "command", new Studnet());
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("spring-mvc")Studnet studnet, ModelMap model){
        model.addAttribute("name", studnet.getName());
        model.addAttribute("age", studnet.getAge());
        model.addAttribute("id", studnet.getId());
        return "result";
    }
}
