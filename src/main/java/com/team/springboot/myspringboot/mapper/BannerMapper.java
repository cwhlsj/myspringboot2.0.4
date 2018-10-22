package com.team.springboot.myspringboot.mapper;


import com.team.springboot.myspringboot.entity.TBanner;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BannerMapper {


    @Select("select * from t_banner where status=1")
    List<TBanner> getAllBanner();
}
