package com.example.service.impl;


import com.example.bean.SystemUser;
import com.example.dao.SystemUserDao;
import com.example.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("systemUserService")
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    SystemUserDao systemUserDao;


    @Transactional(readOnly = true)
    @Override
    public List<SystemUser> findAllUser() {
        //return null;
        return systemUserDao.findAllUser();
    }

    @Transactional(readOnly = true)
    @Override
    public SystemUser findUserByUsername(String username) {
        //return null;
        return systemUserDao.findUserByUsername(username);
    }

    @Transactional
    @Override
    public void saveUsers(SystemUser user) {
        //return null;
        //return systemUserDao.saveUsers(user);
        systemUserDao.saveUsers(user);
    }

    @Transactional
    @Override
    public void deleteUserByUUID(Integer uuid) {
        systemUserDao.deleteUserByUUID(uuid);
    }

    @Transactional
    @Override
    public void updateUser(SystemUser user) {
        systemUserDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUserByUsername(String username) {
        systemUserDao.deleteUserByUsername(username);
    }
}
