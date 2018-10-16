package com.team.springboot.myspringboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TCity {

  private Long id;
  private String cityName;
  private String comment;
  private Date ctime;
  private Date mtime;
  private Integer status;


}
