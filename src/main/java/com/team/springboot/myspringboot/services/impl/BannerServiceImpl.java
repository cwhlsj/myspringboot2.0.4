package com.team.springboot.myspringboot.services.impl;

import com.team.springboot.myspringboot.entity.TBanner;
import com.team.springboot.myspringboot.mapper.BannerMapper;
import com.team.springboot.myspringboot.services.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<TBanner> getAllBanner() {

        return bannerMapper.getAllBanner();
    }
}
