package com.team.springboot.myspringboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TContentMapping {

  private Long id;
  private String type;
  private String content;
  private Integer status;
  private Date ctime;
  private Date mtime;



}
