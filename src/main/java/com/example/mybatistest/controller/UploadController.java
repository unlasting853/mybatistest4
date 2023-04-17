package com.example.mybatistest.controller;

import com.example.mybatistest.classs.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController

public class UploadController {
    @PostMapping("/upload")
    public Result upload(MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        int index = originalFilename.indexOf(".");
        String substring = originalFilename.substring(index);
        String finalfilename = UUID.randomUUID() + substring;
        multipartFile.transferTo(new File("F:\\javaweb\\uploadfile\\"+finalfilename));
        return Result.success();
    }
}
