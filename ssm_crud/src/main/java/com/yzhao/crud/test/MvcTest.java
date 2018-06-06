package com.yzhao.crud.test;

import com.github.pagehelper.PageInfo;
import com.yzhao.crud.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Spring test
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mvc-servlet.xml"})
public class MvcTest {
    //Virtual the mvc request, received the handle result

    //springmvc ioc
    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    public void initMockMvc(){

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void testPage() throws Exception{

        //according the request to get returned result
        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get("/emps")
                .param("pn", "5"))
                .andReturn();


        //after the request successfully, request zone has the "pageInfo", the get the "pageInfo" to validate

        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");

        System.out.println("The Page Number: " + pageInfo.getPageNum());
        System.out.println("Total Page: " + pageInfo.getPages());

        System.out.println("Total records: " + pageInfo.getTotal());

        System.out.println("The shown page on the pages: ");

        int[] nums = pageInfo.getNavigatepageNums();
        for(int i:nums){
            System.out.print(" " + i);
        }

        System.out.println();

        //Get the Employee info
        List<Employee> list  = pageInfo.getList();

        for(Employee employee : list){
            System.out.println("ID: " + employee.getEmpId() + " , Name: " + employee.getEmpName());
        }



    }
}
