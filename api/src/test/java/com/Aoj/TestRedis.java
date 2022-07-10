package com.Aoj;

import com.Aoj.pojo.Vo.UserOnLineVO;
import com.Aoj.service.RankService;
import com.Aoj.service.UserService;
import com.Aoj.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
