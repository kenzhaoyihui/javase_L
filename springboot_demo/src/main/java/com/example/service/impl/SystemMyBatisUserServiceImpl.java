package com.example.service.impl;

import com.example.bean.SystemUser;
import com.example.mapper.SystemUserMapper;
import com.example.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("systemUserServiceMyBatis")
public class SystemMyBatisUserServiceImpl implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Transactional(readOnly = true)
    @Override
    public SystemUser findUserByUsername(String username) {
        //return null;
        return systemUserMapper.findUserByUsername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SystemUser> findAllUser() {
        //return null;
        return systemUserMapper.findAllUsers();
    }

    @Transactional
    @Override
    public void deleteUserByUsername(String username) {
        systemUserMapper.deleteUserByUsername(username);
    }

    @Transactional
    @Override
    public void deleteUserByUUID(Integer uuid) {
        systemUserMapper.deleteUserByUUID(uuid);
    }

    @Transactional
    @Override
    public void updateUser(SystemUser user) {
        systemUserMapper.updateUser(user);
    }

    @Override
    public void saveUsers(SystemUser user) {
        systemUserMapper.saveUser(user);
    }
}
