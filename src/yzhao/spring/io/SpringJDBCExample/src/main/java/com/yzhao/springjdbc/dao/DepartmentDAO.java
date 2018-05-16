package com.yzhao.springjdbc.dao;

import com.yzhao.springjdbc.bean.Department;

import java.util.List;

public interface DepartmentDAO {

    public List<Department> queryDepartment() throws Exception ;

}