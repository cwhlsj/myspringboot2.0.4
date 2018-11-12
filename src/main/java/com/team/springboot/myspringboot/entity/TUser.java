package com.team.springboot.myspringboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class TUser {

  /**
   *
   CREATE TABLE `t_user` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `user_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `ctime` datetime DEFAULT CURRENT_TIMESTAMP,
   `mtime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `status` tinyint(4) DEFAULT NULL,
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
   */

  @Id
  @Column(name = "id")
  private Long id;
  @Column(name = "user_name")
  private String userName;
  @Column(name = "password")
  private String password;
  @Column(name = "phone")
  private String phone;
  @Column(name = "email")
  private String email;
  @Column(name = "address")
  private String address;

  @Column(name = "status")
  private Integer status;
  @Column(name = "ctime")
  private Date ctime;
  @Column(name = "mtime")
  private Date mtime;



}
