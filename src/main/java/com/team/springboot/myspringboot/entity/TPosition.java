package com.team.springboot.myspringboot.entity;

import lombok.Data;

@Data
public class TPosition {

  private Long id;
  private String name;
  private Integer level;
  private java.sql.Timestamp ctime;
  private java.sql.Timestamp mtime;
  private Integer status;



}
