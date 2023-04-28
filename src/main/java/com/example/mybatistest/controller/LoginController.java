package com.example.mybatistest.controller;

import com.example.mybatistest.classs.Login;
import com.example.mybatistest.classs.Result;
import com.example.mybatistest.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class LoginController {
    @Autowired
    LoginService loginServiceImp;
    @PostMapping("/login")
    public Result login(@RequestBody Login login){
            String userid = login.getUserid();
            String password = login.getPassword();
            String token = loginServiceImp.buildtoken(userid,password);
return Result.success(token);
//            return Result.success(jwttoken);
    }

//    @GetMapping("/login")
//    public Result login(String userid,String password){
//
//        String jwttoken = loginServiceImp.buildtoken(userid,password);
//
//        return Result.success(jwttoken);
//    }
}
