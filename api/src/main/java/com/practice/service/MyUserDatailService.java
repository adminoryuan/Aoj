package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 删了启动不了。。。
 */
@Service
public class MyUserDatailService implements UserDetailsService{

    @Autowired
    UserService service;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


                List<GrantedAuthority> authorities = new ArrayList<>();

                // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
                authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));


                return new User("admin",passwordEncoder.encode("admin"),authorities);

    }
}
