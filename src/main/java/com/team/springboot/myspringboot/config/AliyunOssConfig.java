package com.team.springboot.myspringboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("aliyun.oss")
@Data
public class AliyunOssConfig {
    private  String endPoint ;
    private  String accessKeyId ;
    private  String accessKeySecret ;
    private  String bucketName ;
    private   String folder ;

}
