package com.team.springboot.myspringboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


//@MapperScan(basePackages ="com.team.springboot.myspringboot.mapper")
@SpringBootApplication
@MapperScan("com.team.springboot.myspringboot.mapper")
public class MyspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringbootApplication.class, args);
	}


}
