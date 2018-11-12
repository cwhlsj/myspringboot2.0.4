package com.team.springboot.myspringboot.controller;

import com.team.springboot.myspringboot.commom.ResultBody;
import com.team.springboot.myspringboot.entity.TBanner;
import com.team.springboot.myspringboot.mapper.BannerMapper;
import com.team.springboot.myspringboot.services.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/banner")
@RestController
@Slf4j
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @Resource
    private BannerMapper bannerMapper;


    @GetMapping("/getAllBanner")
    public ResultBody getAllBanner(){

        List<TBanner> banners= bannerService.getAllBanner();
        return ResultBody.success(banners);
    }
    @PostMapping("/edit")
    public ResultBody editBannerById(@RequestBody TBanner banner){
        log.info(banner.toString());
        bannerMapper.updateByPrimaryKeySelective(banner);
        return ResultBody.success();
    }

}
