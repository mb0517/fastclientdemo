package com.example.fastclientdemo.service;


import org.springframework.web.multipart.MultipartFile;

public interface FastClientService {
    public String uploadFile(MultipartFile multipartFile);

    public void downloadFile(String  fildid);
}





