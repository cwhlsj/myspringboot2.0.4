package com.team.springboot.myspringboot.controller;

import com.team.springboot.myspringboot.commom.ResultBody;
import com.team.springboot.myspringboot.entity.TDesigner;
import com.team.springboot.myspringboot.mapper.DesignerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/designer")
@Slf4j
public class designerController {

    @Resource
    private DesignerMapper designerMapper;

    @GetMapping("/getDesignersByPosition")
    public ResultBody getDesignersByLevel(Integer position){

        TDesigner designer = new TDesigner();
        designer.setPosition(position);
        designer.setStatus(1);
        return ResultBody.success(designerMapper.select(designer));
    }
}
