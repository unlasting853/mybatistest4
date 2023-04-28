package com.example.mybatistest.mapper;

import com.example.mybatistest.classs.Emp;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from emp")
    Page<Emp> selectemppage(Integer Start, Integer PageSize);
    @Delete("delete from emp where id = #{id}")
    void deleteemp(Integer id);
}
