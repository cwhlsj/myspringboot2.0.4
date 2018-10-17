package com.team.springboot.myspringboot.mapper;

import com.team.springboot.myspringboot.entity.TAdmin;
import com.team.springboot.myspringboot.entity.TCity;
import com.team.springboot.myspringboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminMapper {




    @Select("select count(*) from t_admin")
    int getAdminCount();



    @Select("select * from t_admin where account=#{account} and password=#{password}")
    TAdmin getAdminByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    @Insert("INSERT  INTO `t_admin`(`account`,`name`,`password`,`phone`,`email`,`authority`,`describe`) " +
            "VALUES (#{account},#{name},#{password},#{phone},#{email},#{authority},#{describe})")
    int addAdmin(TAdmin admin);

    @Update("UPDATE t_admin SET " +
            "account=#{account}, name = #{name}, password=#{password}, phone=#{phone} , email=#{email}, authority=#{authority}, describe=#{describe}" +
            "WHERE id=#{id}")
    int updateAdmin(TAdmin admin);

    @Select("select count(*) from t_admin where account =#{account}")
    int checkAdminNameCount(String account);
}
