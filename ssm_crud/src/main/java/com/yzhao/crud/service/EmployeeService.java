package com.yzhao.crud.service;

import com.yzhao.crud.bean.Employee;
import com.yzhao.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    // Select all the Employees
    public List<Employee> getAll(){


        //PageHelper

        return employeeMapper.selectByExampleWithDept(null);
    }
}
