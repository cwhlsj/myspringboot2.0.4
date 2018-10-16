package com.team.springboot.myspringboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TOrder {

  private Long id;
  private String designer;
  private String address;
  private Date bookingTime;
  private String email;
  private String phone;
  private Integer completeStatus;
  private Long uId;
  private Date ctime;
  private Date mtime;
  private Integer status;



}
