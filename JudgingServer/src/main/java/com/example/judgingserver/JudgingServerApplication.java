package com.example.judgingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JudgingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudgingServerApplication.class, args);
    }

}
