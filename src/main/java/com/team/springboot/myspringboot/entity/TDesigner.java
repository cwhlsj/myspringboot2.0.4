package com.team.springboot.myspringboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TDesigner {

  private Long id;
  private String name;
  private Integer position;
  private String introduction;
  private Date ctime;
  private Date mtime;
  private Integer status;



}
