package com.example.mybatistest.classs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageBean {
    List<Emp> empList;
    Long count;
}
