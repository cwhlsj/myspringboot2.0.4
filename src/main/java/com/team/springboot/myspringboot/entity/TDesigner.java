package com.team.springboot.myspringboot.entity;

import lombok.Data;

@Data
public class TDesigner {

  private Long id;
  private String name;
  private Integer position;
  private String introduction;
  private java.sql.Timestamp ctime;
  private java.sql.Timestamp mtime;
  private Integer status;



}
