package com.team.springboot.myspringboot.services;

import com.team.springboot.myspringboot.entity.TAdmin;

public interface AdminService {

    int getAdminCount();

    TAdmin getAdminByAccountAndPassword(String account, String password);

    int addAdmin(TAdmin admin);

    int updateAdmin(TAdmin admin);

    int checkAdminNameCount(String account);
}
