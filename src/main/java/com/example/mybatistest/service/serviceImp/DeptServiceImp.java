package com.example.mybatistest.service.serviceImp;

import com.example.mybatistest.classs.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptServiceImp {
    public List<Dept> list();
    public void delete(Integer id);

    void add(Dept dept);
}
