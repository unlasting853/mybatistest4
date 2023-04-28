package com.example.mybatistest.service.serviceImp;

import com.example.mybatistest.service.LoginService;
import com.example.mybatistest.utils.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public String buildtoken(String userid, String password) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("userid",userid);
        claims.put("password",password);
        String jwttoken = null;
        try {
            jwttoken = TokenGenerator.generateToken("miyao",userid);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        redisTemplate.opsForValue().set(jwttoken,userid,600, TimeUnit.SECONDS);

        return jwttoken;

    }
}
