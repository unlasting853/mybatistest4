package com.example.mybatistest.service;

import com.example.mybatistest.classs.Dept;
import com.example.mybatistest.mapper.DeptMapper;
import com.example.mybatistest.service.serviceImp.DeptServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptService implements DeptServiceImp {
    @Autowired
    DeptMapper deptMapper;
    public List<Dept> list(){
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }
}
