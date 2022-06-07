package com.practice.config.Security;

import com.practice.dto.Userdto;
import com.practice.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class TokenAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisUtils redisUtils;

    public TokenAuthenticationTokenFilter(){
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1、获取请求头携带的token

        String token = request.getHeader("token");

        if(!StringUtils.hasText(token)){
            //不需要token的路由可以直接放行
            filterChain.doFilter(request,response);
            return;
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));


        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(new Userdto(), null, authorities);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);



        filterChain.doFilter(request,response); //放行
    }
}