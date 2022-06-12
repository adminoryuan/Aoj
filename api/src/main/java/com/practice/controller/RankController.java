package com.practice.controller;

import com.practice.common.Result;
import com.practice.pojo.Vo.RankV0;
import com.practice.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yh
 * @date 2022/6/12 下午8:12
 */
@RestController
public class RankController {

    @Autowired
    RankService rServer;

    @GetMapping("/Rank")
    public Result getRank(){

        return Result.ok(rServer.getRank());
    }
}
