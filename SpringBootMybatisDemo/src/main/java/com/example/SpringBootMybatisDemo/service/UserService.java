package com.example.SpringBootMybatisDemo.service;


import com.example.SpringBootMybatisDemo.entity.User;

import java.util.List;

/**
 * 创建人：thj
 * 创建时间： 2018/6/25 14:08
 * 用途：
 */
public interface  UserService {


    public List<User> getUserList(String name,int page,int limit);

    User getUserById(Integer id);

    public int add(User user);

    public int update(User user);

    public int delete(Integer id);

    int getUserCount();
}
