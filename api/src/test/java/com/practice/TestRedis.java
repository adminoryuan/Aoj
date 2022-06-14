package com.practice;

import com.alibaba.fastjson.JSON;
import com.practice.pojo.Dto.Logindto;
import com.practice.pojo.Vo.RankV0;
import com.practice.pojo.Vo.UserOnLineVO;
import com.practice.service.RankService;
import com.practice.service.UserService;
import com.practice.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class TestRedis {

    @Autowired
    RedisUtils utils;
    @Autowired
    RankService Server;

    @Autowired
    UserService ser;
    @Test
    public void T() throws InterruptedException {
        List<UserOnLineVO> userAll = ser.getUserAll(1, 20);


    }
}
