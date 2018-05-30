package com.yzhao.controller;

import com.yzhao.mapper.OrderMapper;
import com.yzhao.mapper.UserMapper;
import com.yzhao.pojo.Order;
import com.yzhao.pojo.User;
import com.yzhao.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @describe: 读取一个用户下的所有订单
 * @author: yzhao
 * @version: V1.0
 * @copyright http://www.kenzhaoyihui.com
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/orders")
    public ModelAndView listall(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        List<Order> orders = userMapper.getOrdersByUserId(1);
        System.out.println("orders");
        ModelAndView modelAndView = new ModelAndView("user_order");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @RequestMapping("/orderpages")
    public ModelAndView pageList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        int currentPage = httpServletRequest.getParameter("page") == null ? 1: Integer.parseInt(httpServletRequest.getParameter("page"));

        int pageSize = 3;
        if (currentPage <= 0){
            currentPage = 1;
        }

        int currentResult = (currentPage - 1) * pageSize;

        System.out.println(httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getQueryString());

        Page page = new Page();
        page.setShowCount(pageSize);
        page.setCurrentResult(currentResult);
        List<Order> orders = userMapper.getOrderListPage(page, 1);

        System.out.println("Current page =>" + page);

        int totalCount = page.getTotalResult();

        int lastPage = 0;
        if (totalCount % pageSize == 0) {
            lastPage = totalCount % pageSize;
        } else {
            lastPage = 1 + totalCount / pageSize;
        }

        if (currentPage >= lastPage) {
            currentPage = lastPage;
        }

        String pageStr = "";

        pageStr = String.format(
                "<a href=\"%s\">上一页</a>    <a href=\"%s\">下一页</a>", httpServletRequest
                        .getRequestURI()
                        + "?page=" + (currentPage - 1), httpServletRequest.getRequestURI()
                        + "?page=" + (currentPage + 1));

        // 制定视图，也就是list.jsp
        ModelAndView mav = new ModelAndView("pagelist");
        mav.addObject("orders", orders);
        mav.addObject("pagelist", pageStr);
        return mav;
    }
}


//public class UserController{
//    private static ApplicationContext applicationContext;
//
//    static{
//        applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//    }
//
//    public static void main(String[] args){
//        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
//        User user = userMapper.getUserById(1);
//
//        System.out.println("User ID=1 : " + user.getUsername() + ", Mobile: " + user.getMobile());
//
//        System.out.println("Get the all order from the user: \n");
//
//        List<Order> orders = userMapper.getOrdersByUserId(2);
//        for(Order order: orders) {
//            System.out.println("Order Number: " + order.getOrderNo() + ", Order money: " + order.getMoney() + ", Order ID: " + order.getOrderId());
//        }
//
//        System.out.println("\nOrder id to select the user: ");
//        OrderMapper orderMapper = (OrderMapper) applicationContext.getBean("orderMapper");
//        User user1 = orderMapper.getUserByOrderId(18);
//        System.out.println("User ID : " + user1.getId() + " , Name: " + user1.getUsername() + ", Mobile: " + user1.getMobile());
//
//    }
//}
