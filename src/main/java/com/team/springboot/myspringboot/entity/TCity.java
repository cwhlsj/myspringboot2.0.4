package com.team.springboot.myspringboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class TCity {

  @Id
  @Column(name = "id")
  private Long id;
  @Column(name = "city_name")
  private String cityName;
  @Column(name = "comment")
  private String comment;
  @Column(name = "status")
  private Integer status;
  @Column(name = "ctime")
  private Date ctime;
  @Column(name = "mtime")
  private Date mtime;

}
