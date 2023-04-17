package com.example.mybatistest.mapper;

import com.example.mybatistest.classs.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();
    @Delete("delete from dept where dept.id=#{id}")
    void delete( Integer id);
}
