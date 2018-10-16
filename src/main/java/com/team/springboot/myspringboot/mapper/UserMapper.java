package com.team.springboot.myspringboot.mapper;

import com.team.springboot.myspringboot.entity.TCity;
import com.team.springboot.myspringboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {


    @Insert("insert  into `tb_user`(`username`,`password`) values  (#{username},#{password})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int saveUser(User user);

    @Select("select * from tb_user")
    List<User> selectAll();


    @Insert("insert into t_city(city_name) values (#{cityName})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int testInsert(TCity tCity);
}
