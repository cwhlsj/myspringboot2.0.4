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
    public TAdmin getAdminByAccountAndPassword(String account, String password) {
        return adminMapper.getAdminByAccountAndPassword(account,password);
    }

    @Override
    public int addAdmin(TAdmin admin) {


        return adminMapper.addAdmin(admin);
    }

    @Override
    public int updateAdmin(TAdmin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public int checkAdminNameCount(String account) {

        return adminMapper.checkAdminNameCount(account);
    }
}
