package com.team.springboot.myspringboot.config;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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


