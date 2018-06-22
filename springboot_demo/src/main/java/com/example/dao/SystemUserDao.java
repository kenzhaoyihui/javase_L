package com.example.dao;

import com.example.bean.SystemUser;

import java.util.List;

public interface SystemUserDao {

    SystemUser findUserByUsername(String username);

    List<SystemUser> findAllUser();

    void saveUsers(SystemUser user);

    void deleteUserByUUID(Integer uuid);
    void  deleteUserByUsername(String username);

    void updateUser(SystemUser user);

}
