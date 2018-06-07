package com.yzhao.crud.service;

import com.yzhao.crud.bean.Employee;
import com.yzhao.crud.bean.EmployeeExample;
import com.yzhao.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


    //getEmp
    public Employee getEmp(Integer id){
        //return employeeMapper.selectByPrimaryKey(id);
        return employeeMapper.selectByPrimaryKeyWithDept(id);
    }

    // Select all the Employees
    public List<Employee> getAll(){
        //PageHelper
        return employeeMapper.selectByExampleWithDept(null);
    }

    public void saveEmp(Employee employee){
        employeeMapper.insertSelective(employee);
    }

    public void updateEmp(Employee employee){
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     *
     * @param empName
     * @return true(empName is available)
     */
    public boolean checkUser(String empName){

        EmployeeExample employeeExample = new EmployeeExample();

        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(employeeExample);

        return count==0;
        //employeeMapper.countByExample()
    }


    public void deleteEmp(Integer id){
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids){
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();

        criteria.andEmpIdIn(ids);
        employeeMapper.deleteByExample(example);
    }
}
