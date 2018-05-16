package com.example.fastclientdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.fastclientdemo.service.FastClientService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    private FastClientService fastClientService;




    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) {
        String id ;
        id = fastClientService.uploadFile(file);
        return id;
    }



    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }
}