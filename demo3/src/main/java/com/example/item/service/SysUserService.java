package com.example.item.service;

import com.example.item.po.SysUser;

import java.util.List;

public interface SysUserService {

    List<SysUser> getAll();

    SysUser detail(Integer userId);
}
