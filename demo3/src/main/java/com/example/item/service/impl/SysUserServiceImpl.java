package com.example.item.service.impl;

import com.example.item.dao.SysUserMapper;
import com.example.item.po.SysUser;
import com.example.item.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper; //报错但是不影响运行
    @Override
    public List<SysUser> getAll() {
        return sysUserMapper.selectByExample(null);
    }

    @Override
    public SysUser detail(Integer userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }
}
