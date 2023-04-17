package com.example.mybatistest.mapper;

import com.example.mybatistest.classs.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();
    @Delete("delete from dept where dept.id=#{id}")
    void delete( Integer id);

   @Insert("insert into dept  (name,create_time,update_time)values (#{name},#{createTime},#{updateTime})" )
    void add(Dept dept);
}
