package com.team.springboot.myspringboot.mapper;


import com.team.springboot.myspringboot.entity.TBanner;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<TBanner> {


    @Select("select * from t_banner where status=1")
    List<TBanner> getAllBanner();
}
