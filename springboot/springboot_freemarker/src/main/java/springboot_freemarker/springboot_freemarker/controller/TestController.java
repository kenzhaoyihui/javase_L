package springboot_freemarker.springboot_freemarker.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import springboot_freemarker.springboot_freemarker.domain.City;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping("/test1")
    @ResponseBody
    public City test1(@RequestBody City city) {
        return city;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public City test2(City city) {
        return city;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public City test3(@RequestParam City city) {
        return city;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("/test4")
    @ResponseBody
    public Date test4(Date date) {
        return date;
    }
}
