package com.Aoj.controller;

import com.Aoj.common.Result;
import com.Aoj.service.RankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yh
 * @date 2022/6/12 下午8:12
 */
@RestController
@Api(value = "Rank",description = "排行榜")

@PreAuthorize("hasRole('ADMIN')")
public class RankController {

    @Autowired
    RankService rServer;

    @GetMapping("/Rank")
    @ApiOperation("/Rank")
    public Result getRank(){

        return Result.ok(rServer.getRank());
    }
}
