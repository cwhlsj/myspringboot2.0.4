package com.team.springboot.myspringboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class TAdmin {

  /**
   *
   CREATE TABLE `t_admin` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `account` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `authority` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
   `ctime` datetime DEFAULT CURRENT_TIMESTAMP,
   `mtime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `status` tinyint(4) DEFAULT '1',
   PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
   */

  @Id
  @Column(name = "id")
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "password")
  private String password;
  @Column(name = "account")
  private String account;
  @Column(name = "phone")
  private String phone;
  @Column(name = "email")
  private String email;
  @Column(name = "description")
  private  String description;
  @Column(name = "authority")
  private String authority;
  @Column(name = "ctime")
  private String ctime;
  @Column(name = "mtime")
  private String mtime;
  @Column(name = "status")
  private Integer status;

}
