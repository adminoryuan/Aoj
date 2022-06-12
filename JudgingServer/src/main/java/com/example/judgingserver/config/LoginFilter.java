package com.example.judgingserver.config;

import com.alibaba.fastjson.JSON;
import com.example.judgingserver.comon.Result;
import com.example.judgingserver.untity.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yh
 * @date 2022/6/12 下午4:04
 */

@WebFilter(value = "/*",filterName = "loginFilter")
public class LoginFilter implements Filter {
    @Autowired
    RedisUtils redisUtils;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;

        HttpServletResponse response=(HttpServletResponse) servletResponse;

        String token = request.getHeader("token");



        Object o =redisUtils.get(token);

        if (o==null){
            response.setStatus(200);
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(JSON.toJSONString(Result.failed(401,"token 非法","")));
            return;
        }
        filterChain.doFilter(request, response);
    }
}
