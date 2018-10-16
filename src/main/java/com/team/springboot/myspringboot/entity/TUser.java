package com.team.springboot.myspringboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TUser {

  private Long id;
  private String userName;
  private String password;
  private String phone;
  private String email;
  private String address;
  private Date ctime;
  private Date mtime;
  private Integer status;



}
