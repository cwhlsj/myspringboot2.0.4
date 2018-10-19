package com.team.springboot.myspringboot.services.impl;


import com.team.springboot.myspringboot.commom.PageBean;
import com.team.springboot.myspringboot.entity.TAdmin;
import com.team.springboot.myspringboot.mapper.AdminMapper;
import com.team.springboot.myspringboot.services.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
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

    @Override
    public PageBean<TAdmin> getQueryAdmins( Integer pageSize,Integer currentPage,String account, String name, String phone, String startDate, String endDate, String email, String authority) {
        PageBean<TAdmin> pageBean=new PageBean(currentPage,pageSize);
        int count= adminMapper.getQueryAdminCount(account,name,phone,startDate,endDate,email,authority);
        List<TAdmin> list= adminMapper.getQueryAdmins(account,name,phone,startDate,endDate,email,authority);
        pageBean.setTotal(count);
        pageBean.setData(list);
        return pageBean;
    }

    @Override
    public List<TAdmin> getAllAdmins() {
        return adminMapper.getAllAdmins();
    }

    @Override
    public PageBean getAdminsByPage(int pageSize, int currentPage) {
        PageBean<TAdmin> pageBean=new PageBean(currentPage,pageSize);
        List<TAdmin> list= adminMapper.findAdminByPage(pageBean.getStartIndex(),pageBean.getPageSize());
        int count=adminMapper.getAdminCount();
        pageBean.setTotal(count);
        pageBean.setData(list);

        log.info(pageBean.toString());
        return pageBean;
    }


}
