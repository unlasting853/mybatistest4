package com.example.mybatistest.service.serviceImp;

import com.example.mybatistest.classs.Dept;
import com.example.mybatistest.mapper.DeptMapper;
import com.example.mybatistest.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImp implements com.example.mybatistest.service.DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmpMapper empMapper;
    public List<Dept> list(){
        return deptMapper.list();
    }
@Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) throws Exception {
        deptMapper.delete(id);
    if(true){
        throw new Exception("出错了，抛出异常");
    }
    empMapper.deleteemp(id);


}

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

}
