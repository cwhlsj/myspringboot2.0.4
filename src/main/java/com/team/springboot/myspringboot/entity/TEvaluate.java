package com.team.springboot.myspringboot.entity;

import lombok.Data;

@Data
public class TEvaluate {

  private Long id;
  private String title;
  private String coverImg;
  private Long contentId;
  private String author;
  private Integer commend;
  private java.sql.Timestamp ctime;
  private java.sql.Timestamp mtime;
  private Integer status;




}
