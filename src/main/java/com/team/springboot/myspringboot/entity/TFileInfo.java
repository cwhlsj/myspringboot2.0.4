package com.team.springboot.myspringboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TFileInfo {

  private Long id;
  private String fileName;
  private String fileUrl;
  private Date ctime;
  private Date mtime;
  private String type;
  private Integer status;
  private Integer mappingId;



}
