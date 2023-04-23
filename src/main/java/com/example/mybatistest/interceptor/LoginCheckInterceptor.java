package com.example.mybatistest.interceptor;

import com.example.mybatistest.utils.JwtUtils;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return true为放行,return false为阻拦
        System.out.println("prehandle..............................");//代表进入拦截器
        String url = request.getRequestURI().toString();

//        if (url.contains("login")){
//            log.info("登录操作，放行。。。");
//            return true;
//        }

        String token = request.getHeader("token");
        if(!StringUtils.hasLength("token")){
            log.info("token为空，未登录");
            return false;
        }
//        try{
//            JwtUtils.parseJWT(token);
//        } catch (Exception e){
//            log.info("令牌失效");
//            return false;
//        }
        String str = redisTemplate.opsForValue().get(token);
        System.out.println(str);
        if (str.isEmpty()) {
            log.info("身份验证失败");
            return false;
        }


//
//        if(!token.equals("token1"))
//            return false;
        //令牌合法，放行



        log.info("令牌合法，放行");
        return true;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("posthandle..............................");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("aftercompletion..........................");
    }
}
