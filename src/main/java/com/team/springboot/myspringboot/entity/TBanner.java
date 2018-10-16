package com.team.springboot.myspringboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TBanner {

  private Long id;
  private String imagePath;
  private String link;
  private Integer display;
  private Integer status;
  private Date ctime;
  private Date mtime;



}
