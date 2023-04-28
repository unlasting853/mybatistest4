package com.example.mybatistest.controller;

import com.example.mybatistest.classs.Emp;

import com.example.mybatistest.classs.PageBean;
import com.example.mybatistest.classs.Result;
import com.example.mybatistest.service.EmpService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;



    @GetMapping("/emp")
    public Result selectemp( Integer Start, Integer PageSize){
        System.out.println(Start);
        System.out.println(PageSize);
         PageBean empPage = empService.page(Start,PageSize);
        return Result.success(empPage);
    }
}
