package com.team.springboot.myspringboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class TBanner {

  /**
   *
   CREATE TABLE `t_banner` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `image_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片路径',
   `link` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '链接地址',
   `display` tinyint(1) DEFAULT NULL COMMENT '是否展示，1是展示',
   `status` tinyint(1) DEFAULT NULL COMMENT '删除标志，是否删除，1是删除',
   `ctime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `mtime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
   */

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "image_path")
  private String imagePath;
  @Column(name = "link")
  private String link;
  @Column(name = "display")
  private Integer display;
  @Column(name = "status")
  private Integer status;
  @Column(name = "ctime")
  private Date ctime;
  @Column(name = "mtime")
  private Date mtime;



}
