package com.team.springboot.myspringboot.services;

import com.team.springboot.myspringboot.entity.TAdmin;

public interface AdminService {

    int getAdminCount();

    TAdmin getAdminByUserNameAndPassword(String name, String password);
}
