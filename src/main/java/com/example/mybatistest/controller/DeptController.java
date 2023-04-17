package com.example.mybatistest.controller;

import com.example.mybatistest.classs.Dept;
import com.example.mybatistest.classs.Result;
import com.example.mybatistest.service.DeptService;
import com.example.mybatistest.service.serviceImp.DeptServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    DeptServiceImp deptService;
//    查询全部部门信息
    @GetMapping("/depts")
    public Result list(){
        Result result=new Result();

        return result.success(deptService.list());

    }
//    用get方法以路径传id删除部门
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        deptService.delete(id);
        return Result.success();
    }
//    用post方法，以requsetbody注解获取post中body
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        return Result.success();
    }
}
