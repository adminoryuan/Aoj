package com.example.judgingserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.example.judgingserver.mapper")
@EnableFeignClients
public class JudgingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudgingServerApplication.class, args);
    }

}

