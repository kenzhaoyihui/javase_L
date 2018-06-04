package com.yzhao.crud.test;

import com.yzhao.crud.bean.Department;
import com.yzhao.crud.bean.Employee;
import com.yzhao.crud.dao.DepartmentMapper;
import com.yzhao.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD(){
//        //1. create the spring ioc
//        //2. get mapper
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);


        // Spring test(recomemcord)
        System.out.println(departmentMapper);

        // Insert Dev and Test Department
//        departmentMapper.insertSelective(new Department(null, "Dev"));
//        departmentMapper.insertSelective(new Department(null, "Test"));


        // insert employee
        //employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@redhat.com", 1));

        // insert the more employees

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i=0; i<1000; i++){
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            employeeMapper.insertSelective(new Employee(null, uid, "M", uid+"@redhat.com", 1));
        }


    }
}
