package com.example.mybatistest.mapper;

import com.example.mybatistest.classs.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper {
//   @Select("select * from user")
    public List<User>userlist();
    @Delete("delete from user where id=#{id}")
    public void delete(Integer id);
    @Options(useGeneratedKeys = true,keyProperty = "id")//获取其自动增长的主键id
    @Insert("insert into user( name, age, gender, phone) VALUES (#{name},#{age},#{gender},#{phone})")
    public void insert(User user);


    public void update(User user);
    public void delete2(List<Integer> dlist);

}
