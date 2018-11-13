package com.team.springboot.myspringboot.mapper;

import com.team.springboot.myspringboot.entity.TCity;
import com.team.springboot.myspringboot.entity.TUser;
import com.team.springboot.myspringboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.common.Mapper;

public interface CityMapper extends Mapper<TCity> {

}
