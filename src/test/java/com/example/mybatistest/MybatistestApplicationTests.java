package com.example.mybatistest;

import com.example.mybatistest.classs.User;
import com.example.mybatistest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatistestApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
	}
	@Test
	void mybatistest1(){
		userMapper.delete(6);//删除操作
		List<User> list=userMapper.userlist();//遍历输出
		list.stream().forEach(user -> {
			System.out.println(user);
		});


	}
	@Test
	void mybatistest2(){
		User user = new User();
		user.setName("zhanghu");
		user.setAge((short) 14);
		user.setGender((short) 1);
		user.setPhone("12306");
		userMapper.insert(user);
		System.out.println(user.getId());


	}
	@Test
	void mybatistest3(){
		User user = new User();
		user.setId(1);
		user.setName("zhangsan");
		user.setAge((short) 15);
		user.setGender((short) 1);
		user.setPhone("853529");
		userMapper.update(user);
	}
	@Test
	void mybatistest4(){
		User user = new User();
		List<User> userlist = userMapper.userlist();
		System.out.println(userlist);
	}
	@Test//动态更新（使用if标签）
	void mybatistest5(){
		User user = new User();
		user.setId(2);

		user.setPhone("1123");
		user.setAge((short) 18);
		userMapper.update(user);

	}
	@Test
	void mybatistest6(){
		List<Integer> dlist=
		Arrays.asList(1,3,6);
		userMapper.delete2(dlist);
	}

}
