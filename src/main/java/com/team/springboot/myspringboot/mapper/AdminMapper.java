package com.team.springboot.myspringboot.mapper;

import com.team.springboot.myspringboot.entity.TAdmin;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminMapper extends Mapper<TAdmin> {

    @Select("select count(*) from t_admin")
    int getAdminCount();
    @Select("select * from t_admin where account=#{account} and password=#{password} and status=1 ")
    TAdmin getAdminByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    @Insert("INSERT  INTO `t_admin`(`account`,`name`,`password`,`phone`,`email`,`authority`,`description`) " +
            "VALUES (#{account},#{name},#{password},#{phone},#{email},#{authority},#{description})")
    int addAdmin(TAdmin admin);

    @Update("UPDATE t_admin SET " +
            "account=#{account}, name = #{name}, password=#{password}, phone=#{phone} , email=#{email}, authority=#{authority}, description=#{description}, " +
            "status=#{status}  WHERE id=#{id}")
    int updateAdmin(TAdmin admin);

    @Select("select count(*) from t_admin where account =#{account}")
    int checkAdminNameCount(String account);

    @Select("<script>" +
            "select * from t_admin" +
            "<where>" +
                "<if test='account!=null '>" +
                    "and account LIKE (CONCAT('%', #{account}, '%'))" +
                "</if>" +
                "<if test='name!=null '>" +
                    "and name LIKE (CONCAT('%', #{name}, '%'))" +
                "</if>" +
                "<if test='phone!=null '>" +
                    "and phone LIKE (CONCAT('%', #{phone}, '%'))" +
                "</if>" +
                "<if test='startDate!=null and endDate!=null '>" +
                    "and ctime between #{startDate} and #{endDate}" +
                "</if>" +
                "<if test='email!=null '>" +
                    "and email LIKE (CONCAT('%', #{email}, '%'))" +
                "</if>" +
                "<if test='authority!=null '>" +
                    "and authority =#{authority}" +
                "</if>" +
                 "and status=1" +
            "</where>" +
            "order by ctime desc" +
            "</script>")
    List<TAdmin> getQueryAdmins(@Param("account") String account, @Param("name") String name, @Param("phone") String phone, @Param("startDate") String startDate,
                              @Param("endDate") String endDate,@Param("email") String email,@Param("authority") String authority);

    @Select("select * from t_admin where status=1 order by ctime desc")
    List<TAdmin> getAllAdmins();

    @Select("select * from t_admin where  status=1  limit #{startIndex},#{pageSize} order by ctime desc")
    List<TAdmin> findAdminByPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);


    @Select("<script>" +
            "select count(*) from t_admin" +
            "<where>" +
            "<if test='account!=null '>" +
            "and account LIKE (CONCAT('%', #{account}, '%'))" +
            "</if>" +
            "<if test='name!=null '>" +
            "and name LIKE (CONCAT('%', #{name}, '%'))" +
            "</if>" +
            "<if test='phone!=null '>" +
            "and phone LIKE (CONCAT('%', #{phone}, '%'))" +
            "</if>" +
            "<if test='startDate!=null and endDate!=null '>" +
            "and ctime between #{startDate} and #{endDate}" +
            "</if>" +
            "<if test='email!=null '>" +
            "and email LIKE (CONCAT('%', #{email}, '%'))" +
            "</if>" +
            "<if test='authority!=null '>" +
            "and authority =#{authority}" +
            "</if>" +
            "and status=1" +
            "</where>" +
            "</script>")
    int getQueryAdminCount(@Param("account") String account, @Param("name") String name, @Param("phone") String phone, @Param("startDate") String startDate,
                           @Param("endDate") String endDate,@Param("email") String email,@Param("authority") String authority);

    @Select("select * from t_admin where id=#{id}")
    TAdmin getAdminById(Integer id);
}
