package com.team.springboot.myspringboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TAdmin {

  private Long id;
  private String name;
  private String password;
  private String account;
  private String phone;
  private String email;
  private  String describe;
  private String authority;
  private Date ctime;
  private Date mtime;
  private Integer status;




}
