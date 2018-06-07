package com.yzhao.crud.bean;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * JSR 303 validate --> hibernate validate
 */
public class Employee {
    private Integer empId;

    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16})|(^[\u2E80-\u9FFF]{2,5})", message = "empName should be 2-5 Chinese or 6-16 Engish")
    private String empName;

    private String gender;

    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", message = "Email is not valid")
    private String email;

    private Integer dId;

    private Department department;

    public Employee(Integer empId, String empName, String gender, String email, Integer dId) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }

//    public Employee(Integer empId, String empName, String gender, String email, Integer dId, Department department) {
//        this.empId = empId;
//        this.empName = empName;
//        this.gender = gender;
//        this.email = email;
//        this.dId = dId;
//        this.department = department;
//    }

    public Employee(){}

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}