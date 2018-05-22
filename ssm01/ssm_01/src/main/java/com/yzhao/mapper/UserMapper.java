package com.yzhao.mapper;

import com.yzhao.pojo.Order;
import com.yzhao.pojo.User;
import com.yzhao.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public User getUserById(int id);
    public List<Order> getOrdersByUserId(int id);
    public List<Order> getOrderListPage(@Param("page") Page page, @Param("userid") int userid);
}
