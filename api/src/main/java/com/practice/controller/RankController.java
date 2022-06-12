package com.practice.controller;

import com.practice.common.Result;
import com.practice.pojo.Vo.RankV0;
import com.practice.service.RankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yh
 * @date 2022/6/12 下午8:12
 */
@RestController
@Api(value = "Rank",description = "排行榜")
public class RankController {

    @Autowired
    RankService rServer;

    @GetMapping("/Rank")
    @ApiOperation("/Rank")
    public Result getRank(){

        return Result.ok(rServer.getRank());
    }
}
