package com.team.springboot.myspringboot.services.impl;

import com.team.springboot.myspringboot.entity.TAdmin;
import com.team.springboot.myspringboot.mapper.AdminMapper;
import com.team.springboot.myspringboot.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public int getAdminCount() {
        return adminMapper.getAdminCount();
    }

    @Override
    public TAdmin getAdminByUserNameAndPassword(String name, String password) {
        return adminMapper.getAdminByUserNameAndPassword(name,password);
    }
}
