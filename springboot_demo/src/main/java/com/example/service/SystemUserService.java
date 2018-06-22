package com.example.service;

import com.example.bean.SystemUser;

import java.util.List;

public interface SystemUserService {

    SystemUser findUserByUsername(String username);

    List<SystemUser> findAllUser();

    void saveUsers(SystemUser user);

    void deleteUserByUUID(Integer uuid);

    void updateUser(SystemUser user);

    void deleteUserByUsername(String username);
}
