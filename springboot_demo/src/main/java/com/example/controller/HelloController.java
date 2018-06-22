package com.example.controller;



import com.example.bean.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class HelloController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello")
    public String say(){
        return "Hello LJ!";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @GetMapping("/home")
    public String toHome() {
        return "home";
    }

    @RequestMapping("/index1")
    public String toIndex1() {
        return "home";
    }

    @RequestMapping("/students")
    public String students(Map<String, Object> map) {
        List<Student> list = new ArrayList<>();

        for(int i=0;i<10;i++){
            Student student = new Student();
            student.setName("ZYH" + i);
            student.setAge(23 + i);
            list.add(student);
        }

        map.put("sList", list);
        logger.info("studentList: {}", list);
        return "students";
    }

    @RequestMapping("/student/{name}")
    public String student(@PathVariable(name = "name") String name, Map<String, Object> map) {
        Student student = new Student();
        student.setName(name);
        student.setAge(23);
        map.put("student", student);

        return "student";
    }
}