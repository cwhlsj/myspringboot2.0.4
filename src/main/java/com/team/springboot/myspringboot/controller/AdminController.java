package com.team.springboot.myspringboot.controller;


import com.team.springboot.myspringboot.commom.PageBean;
import com.team.springboot.myspringboot.commom.ResultBody;
import com.team.springboot.myspringboot.entity.TAdmin;
import com.team.springboot.myspringboot.services.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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

        admin=adminService.getAdminByAccountAndPassword(admin.getAccount(),admin.getPassword());
        if (admin!=null){
            request.getSession().setAttribute("admin",admin);
            map.put("status","ok");
            map.put("currentAuthority",admin.getAuthority());
        }
        return map;
    }


    @PostMapping("/addOrUpdateAdmin")
    public ResultBody addAdmin(@RequestBody TAdmin admin){

        log.info(admin.toString());
        if(admin.getId()==null){
            int flag=adminService.addAdmin(admin);
            if(flag==1)
                return ResultBody.success();
            else return ResultBody.fail("新增管理员失败");
        }
        else {
           int flag= adminService.updateAdmin(admin);
           if (flag==1)
               return ResultBody.success();
           else return ResultBody.fail("更新管理员失败");
        }

    }

    @GetMapping("/checkAdminCount")
    public ResultBody checkAdminNameCount(String account){
        int flag=adminService.checkAdminNameCount(account);
        return ResultBody.success(flag);
    }

    @GetMapping("getAdminsByPage")
    public ResultBody getAdminsByPage (int pageSize,int currentPage){

        PageBean pageBean=adminService.getAdminsByPage(pageSize,currentPage);

        return ResultBody.page(pageBean.getTotal(),pageBean.getCurrent(),pageBean.getPageSize(),pageBean.getData());
    }

    @GetMapping("/getAllAdminData")
    public ResultBody getQueryAdmins(Integer pageSize,Integer currentPage,String account,String name,String phone,String startDate,String endDate,String email,String authority){

        if (startDate!=null&&startDate.equalsIgnoreCase(""))
            startDate=null;
        if (endDate!=null&&endDate.equalsIgnoreCase(""))
            endDate=null;


        if(currentPage==null){
            currentPage=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        if(startDate!=null&&!startDate.equalsIgnoreCase("")){
            startDate=startDate+" 00:00:00";
        }
        if(endDate!=null&&!endDate.equalsIgnoreCase("")){
            endDate=endDate+" 23:59:59";
        }
        PageBean pageBean=adminService.getQueryAdmins(pageSize,currentPage,account,name,phone,startDate,endDate,email,authority);

        return ResultBody.page(pageBean.getTotal(),pageBean.getCurrent(),pageBean.getPageSize(),pageBean.getData());
    }

}
