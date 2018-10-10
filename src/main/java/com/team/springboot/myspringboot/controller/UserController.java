package com.team.springboot.myspringboot.controller;
import com.team.springboot.myspringboot.config.AlipayConfig;
import com.team.springboot.myspringboot.config.AliyunOssConfig;
import com.team.springboot.myspringboot.entity.User;
import com.team.springboot.myspringboot.mapper.UserMapper;
import com.team.springboot.myspringboot.util.AliyunOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Resource
    private  UserMapper userMapper;

    @Autowired
    private AliyunOssUtil aliyunOssUtil;

    @Autowired
    private AliyunOssConfig aliyunOssConfig;

    @Autowired
    AlipayConfig alipayConfig;

    @RequestMapping("/hello")
    public AliyunOssConfig insertUser(){

//        User user=new User();
//        user.setUsername("1");
//        user.setAddress("44");
//        user.setEmail("123");
//        user.setPassword("123");
//        user.setIsvalidate(55);
//        user.setUImage("11");
//        int k=userMapper.saveUser(user);
//        log.info(user.toString());
        return aliyunOssConfig;
    }





    @RequestMapping("selectAll")
    public List<User> selectAll(){

        return userMapper.selectAll();
    }


    @GetMapping("alipay")
    public AlipayConfig alipay(){

        alipayConfig.getAlipay_public_key();
        log.info(alipayConfig.toString());
        return alipayConfig;

    }




}
