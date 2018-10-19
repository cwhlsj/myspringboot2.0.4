package com.team.springboot.myspringboot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableTransactionManagement// 开启事务
@MapperScan(basePackages ="com.team.springboot.myspringboot.mapper")
@SpringBootApplication
public class MyspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringbootApplication.class, args);
	}


}
