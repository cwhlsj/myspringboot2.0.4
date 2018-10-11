package com.team.springboot.myspringboot.util;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

import com.team.springboot.myspringboot.config.AliyunOssConfig;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.BucketInfo;


@Component
public class AliyunOssUtil {

    @Autowired
    private  AliyunOssConfig ossConfig;

    /**
     * 判断是否存在bucketName
     * @return
     */
    private  boolean hasBucket(OSSClient ossClient){
        return ossClient.doesBucketExist(ossConfig.getBucketName());
    }

    /**
     * 不存在则创建bucket实例
     */
    private  void creatBucket(OSSClient ossClient){
        if(!hasBucket(ossClient))
            ossClient.createBucket(ossConfig.getBucketName());
    }


    /**
     * 获取ossClient
     * @return
     */
    public  OSSClient ossClientInitialization(){
        return new OSSClient(ossConfig.getEndPoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());
    }

    /**
     * 获取bucket信息
     */
    private BucketInfo getBucketInfo(OSSClient ossClient){
        return ossClient.getBucketInfo(ossConfig.getBucketName());
    }

    /**
     * 文件上传并返回文件路径
     * @param file
     * @return
     * @throws IOException
     */
    public  String fileUpload(MultipartFile file) throws IOException{
        OSSClient ossClient = ossClientInitialization();
        creatBucket(ossClient);
        //原文件名
        String originalFilename = file.getOriginalFilename();

        String fileName = getFileName(originalFilename);
        // 上传文件流
        InputStream inputStream = file.getInputStream();
        String path=ossConfig.getFolder()+"/"+fileName;
        ossClient.putObject(ossConfig.getBucketName(), path, inputStream);
        String url = getUrl(ossClient,fileName);
        ossClient.shutdown();
        return url;
    }

    /**
     * 获取附件上传保存到服务器的名称，返回当前时间的时间戳为文件名
     * @param fileName    文件原始名称
     * @return
     */
    public  String getFileName(String fileName){
        if(StringUtils.isBlank(fileName)){
            return null;
        }
        if(fileName.lastIndexOf(".")>-1){
            fileName = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        }else{
            fileName = "."+fileName.toLowerCase();
        }
        Date date = new Date();
        long t = date.getTime();
        return String.valueOf(t)+fileName;
    }

    /**
     * 获得url链接
     *
     * @param fileName
     * @return
     */
    public  String getUrl(OSSClient ossClient,String fileName) {
        fileName=ossConfig.getFolder()+"/"+fileName;
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(ossConfig.getBucketName(), fileName, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }
}