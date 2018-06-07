package com.yzhao.crud.controller;

import com.yzhao.crud.bean.Department;
import com.yzhao.crud.bean.Msg;
import com.yzhao.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> departmentList = departmentService.getDepts();
        return Msg.success().add("depts", departmentList);
    }
}
