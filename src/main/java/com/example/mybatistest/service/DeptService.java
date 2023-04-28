package com.example.mybatistest.service;

import com.example.mybatistest.classs.Dept;

import java.util.List;


public interface DeptService {
    public List<Dept> list();
    public void delete(Integer id) throws Exception;

    void add(Dept dept);
}
