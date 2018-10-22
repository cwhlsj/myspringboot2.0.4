package com.team.springboot.myspringboot.services;

import com.team.springboot.myspringboot.commom.PageBean;
import com.team.springboot.myspringboot.entity.TAdmin;

import java.util.List;
import java.util.Map;

public interface AdminService {

    int getAdminCount();

    TAdmin getAdminByAccountAndPassword(String account, String password);

    int addAdmin(TAdmin admin);

    int updateAdmin(TAdmin admin);

    int checkAdminNameCount(String account);

    PageBean<TAdmin> getQueryAdmins(Integer pageSize,Integer current,String account, String name, String phone, String startDate, String endDate, String email, String authority);

    List<TAdmin> getAllAdmins();

    PageBean getAdminsByPage(int pageSize, int current);

    TAdmin getAdminById(Integer id);
}
