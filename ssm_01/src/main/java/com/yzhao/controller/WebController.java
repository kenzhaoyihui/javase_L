package com.yzhao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/staticpage", method = RequestMethod.GET)
    public String redirect(){
        return "redirect:/html1/final.html";
    }

    @RequestMapping(value = "/finalpage", method = RequestMethod.GET)
    public String finalPage(){
        return "final";
    }
}
