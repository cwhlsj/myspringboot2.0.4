package com.team.springboot.myspringboot.controller;

import com.team.springboot.myspringboot.commom.ResultBody;
import com.team.springboot.myspringboot.entity.TBanner;
import com.team.springboot.myspringboot.services.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/banner")
@RestController
public class BannerController {

    @Autowired
    private BannerService bannerService;


    @GetMapping("/getAllBanner")
    public ResultBody getAllBanner(){

        List<TBanner> banners= bannerService.getAllBanner();


        return ResultBody.success(banners);
    }

}
