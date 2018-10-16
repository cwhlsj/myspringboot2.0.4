package com.team.springboot.myspringboot.mapper;

import com.team.springboot.myspringboot.entity.TAdmin;
import com.team.springboot.myspringboot.entity.TCity;
import com.team.springboot.myspringboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper {


//    @Insert("insert  into `tb_user`(`username`,`password`) values  (#{username},#{password})")
//    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
//    int saveUser(User user);
//
//    @Select("select * from tb_user")
//    List<User> selectAll();
//
//
//    @Insert("insert into t_city(city_name) values (#{cityName})")
//    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
//    int testInsert(TCity tCity);


    @Select("select count(*) from t_admin")
    int getAdminCount();
    @Select("select * from t_admin where name=#{name} and password=#{password}")
    TAdmin getAdminByUserNameAndPassword(@Param("name") String name, @Param("password") String password);
}
