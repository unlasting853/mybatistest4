package com.example.mybatistest.controller;

import com.example.mybatistest.classs.Result;
import com.example.mybatistest.service.DeptService;
import com.example.mybatistest.service.serviceImp.DeptServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class DeptController {
    @Autowired
    DeptServiceImp deptService;
    @GetMapping("/depts")
    public Result list(){
        Result result=new Result();

        return result.success(deptService.list());

    }
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        deptService.delete(id);
        return Result.success();
    }
}
