package com.team.springboot.myspringboot.controller;
import com.team.springboot.myspringboot.commom.ResultBody;
import com.team.springboot.myspringboot.entity.TUser;
import com.team.springboot.myspringboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private  UserMapper userMapper;

}
