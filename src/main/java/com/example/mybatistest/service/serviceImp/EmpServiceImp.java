package com.example.mybatistest.service.serviceImp;

import com.example.mybatistest.classs.Emp;
import com.example.mybatistest.classs.PageBean;
import com.example.mybatistest.mapper.EmpMapper;
import com.example.mybatistest.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    EmpMapper empMapper;


    @Override
    public PageBean page(Integer Start, Integer PageSize) {
        PageHelper.startPage(Start,PageSize);
        System.out.println("传入pagehelpler"+Start+PageSize);
        Page<Emp> page =  empMapper.selectemppage(Start,PageSize);

        PageBean pageBean = new PageBean(page.getResult(), page.getTotal());



        return pageBean;
    }

}
