package com.yzhao.crud.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzhao.crud.bean.Employee;
import com.yzhao.crud.bean.Msg;
import com.yzhao.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * handle CRUD request
 *
 * Rest URI:
 * /emp/{id}  GET --> select
 * /emp       POST --> save
 * /emp/{id}  PUT --> update
 * /emp/{id}  DELETE --> delete
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    /**
     * page select
     * @return
     *
     * single :1
     * multi: 1-2-3
     */

    @ResponseBody
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public Msg deleteEmpById(@PathVariable("id") String id){
        if(id.contains("-")){
            List<Integer> list_ids = new ArrayList<>();
            String[] str_ids = id.split("-");

            for(String s: str_ids){
                list_ids.add(Integer.parseInt(s));
            }
            employeeService.deleteBatch(list_ids);
        }else{
            employeeService.deleteEmp(Integer.parseInt(id));
        }

        return Msg.success();
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmp(id);
        return Msg.success().add("emp", employee);
    }

    @ResponseBody
    @RequestMapping("/checkuser")
    public Msg checkuser(@RequestParam("empName") String empName){

        String regx = "(^[a-zA-Z0-9_-]{6,16})|(^[\\u2E80-\\u9FFF]{2,5})";

        if (!empName.matches(regx)){
            return Msg.fail().add("va_msg", "empName should be 2-5 Chinese or 6-16 Engish...");
        }


        //database double check validate
        boolean b = employeeService.checkUser(empName);

        if (b){
            return Msg.success();
        }else{
            return Msg.fail().add("va_msg", "EmpName is unavailable...");
        }
    }


    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result){
        if(result.hasErrors()){

            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();

            for(FieldError fieldError : errors){
                System.out.println("Error Field: " + fieldError.getField());
                System.out.println("Error message: " + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else{
            employeeService.saveEmp(employee);
            return Msg.success();
        }
    }


    //Update the employee, need to config HttpPutFormContentFilter
    // request date -> map
    // request.getParameter() method override

    @ResponseBody
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    public Msg saveEmp(Employee employee, HttpServletRequest request){
        //System.out.println("Request body: " + request);
        System.out.println("Request body value:" + request.getParameter("gender"));

        employeeService.updateEmp(employee);
        System.out.println(employee);
        return Msg.success();
    }

    //Return json String
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        PageHelper.startPage(pn, 5);
        List<Employee> emps = employeeService.getAll();

        PageInfo pageInfo = new PageInfo(emps, 5);

        return Msg.success().add("pageInfo", pageInfo);
    }


    //@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){

        //PageHelper, page number and pageSize
        PageHelper.startPage(pn, 5);

        List<Employee> emps = employeeService.getAll();

        //PageInfo, include the details info and data
        PageInfo pageInfo = new PageInfo(emps, 5);

        model.addAttribute("pageInfo", pageInfo);
        return "list";
    }
}
