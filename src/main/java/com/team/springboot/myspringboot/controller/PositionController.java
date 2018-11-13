package com.team.springboot.myspringboot.controller;

import com.team.springboot.myspringboot.commom.ResultBody;
import com.team.springboot.myspringboot.mapper.PositionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/position")
@Slf4j
public class PositionController {

    @Resource
    private PositionMapper positionMapper;

    @GetMapping("/getPositions")
    public ResultBody getPositions(){

        return ResultBody.success(positionMapper.selectAll());
    }

}
