package com.team.springboot.myspringboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TPosition {

  private Long id;
  private String name;
  private Integer level;
  private Date ctime;
  private Date mtime;
  private Integer status;



}
