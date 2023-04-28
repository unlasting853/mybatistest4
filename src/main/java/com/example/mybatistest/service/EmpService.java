package com.example.mybatistest.service;



import com.example.mybatistest.classs.PageBean;
import org.springframework.data.domain.Page;

public interface EmpService {
    public PageBean page(Integer Start,Integer PageSide);
}
