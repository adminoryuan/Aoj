package com.practice;

import com.practice.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class TestRedis {

    @Autowired
    RedisUtils until;
    @Test
    public void Test(){
        until.set("name","张三");
        System.out.println(until.get("name"));
    }
}
