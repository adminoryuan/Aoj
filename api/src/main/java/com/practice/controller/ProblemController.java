package com.practice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.practice.common.Result;
import com.practice.entity.Problem;
import com.practice.pojo.Dto.ProblemDto;
import com.practice.service.ProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:54:03
 */

@Api(value = "ProblemController", description = "获取题目接口")
@RestController

@PreAuthorize("ADMIN")
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    ProblemService service;

    @PostMapping("/getProbleAll")
    @ApiOperation("获取问题列表")
    public Result getProbleAll(@RequestParam int page,@RequestParam int size){
        return Result.ok(service.list());
    }

    @PostMapping("/getProblem")
    @ApiOperation("获取详细数据")
    public Result getProblem(@RequestParam  String proid){
        return Result.ok(service.getOne(new QueryWrapper<Problem>().eq("id",proid)));
    }


    @PostMapping("/addPromblem")
    @ApiOperation("添加题目")
    public Result addProblem(@RequestBody ProblemDto dto){
        if (service.AddProblem(dto)){
            return Result.failed("请填写正确的数据");
        }

        return Result.ok("成功");
    }

}
