package com.team.springboot.myspringboot.controller;

import com.team.springboot.myspringboot.entity.TAdmin;
import com.team.springboot.myspringboot.services.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {


    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    public Map<String,Object> userLogin(@RequestBody TAdmin admin, HttpServletRequest request){

        log.info(admin.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("status","error");
        map.put("currentAuthority","guest");
        map.put("type","account");

        admin=adminService.getAdminByUserNameAndPassword(admin.getName(),admin.getPassword());
        if (admin!=null){
            request.getSession().setAttribute("admin",admin);
            map.put("status","ok");
            map.put("currentAuthority",admin.getAuthority());
        }
        return map;
    }

}
