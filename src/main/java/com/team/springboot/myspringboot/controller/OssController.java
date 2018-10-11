package com.team.springboot.myspringboot.controller;

import com.team.springboot.myspringboot.util.AliyunOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RequestMapping("/upload")
@RestController
public class OssController {

    @Autowired
    private AliyunOssUtil aliyunOssUtil;

    @PostMapping("/file")
    public String  SaveFile(MultipartFile file) throws IOException {
        String url = aliyunOssUtil.fileUpload(file);
        return url;
    }
}
