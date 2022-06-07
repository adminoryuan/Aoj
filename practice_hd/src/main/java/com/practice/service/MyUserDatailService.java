package com.practice.service;

import com.practice.dto.Userdto;
import com.practice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * w
 */
@Service
public class MyUserDatailService implements UserDetailsService{

    @Autowired
    UserService service;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("进入 loadUserByUserName.....");
        Userdto userdto = new Userdto();
        userdto.setUserName(username);
        userdto.setPassword("1234");
        userdto.setRole("ROLE_ADMIN");

//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));


        return userdto;

    }
}