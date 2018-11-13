package com.team.springboot.myspringboot.controller;

import com.team.springboot.myspringboot.commom.ResultBody;
import com.team.springboot.myspringboot.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/city")
@Slf4j
public class CityController {

    @Resource
    private CityMapper cityMapper;

    @GetMapping("/getCities")
    public ResultBody getCities(){
        return ResultBody.success(cityMapper.selectAll());
    }
}
