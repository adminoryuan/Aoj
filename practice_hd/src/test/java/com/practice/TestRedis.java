package com.practice;

import com.alibaba.fastjson.JSON;
import com.practice.dto.Userdto;
import com.practice.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TestRedis {

    @Autowired
    RedisUtils until;
    @Test
    public void Test(){
        Userdto dto=new Userdto();
        dto.setPassword("adad");
        dto.setRole("hhehehas");
        dto.setUserName("adm");
        until.set("hh",dto,100);

        Map<String,String> maps=new HashMap<>();

        Map hh = JSON.parseObject(until.get("hh").toString(), maps.getClass());

        System.out.println();
        System.out.println(hh);
        System.out.println(hh.get("role"));
        System.out.println(maps.get(" role"));


    }
}
