package com.Aoj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@MapperScan("com.Aoj.mapper")
@EnableGlobalAuthentication
public class PracticeApplication {
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }
    public static void main(String[] args) {
    System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(PracticeApplication.class,args);
    }
}
