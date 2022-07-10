package com.Aoj.controller;

import com.Aoj.common.Result;
import com.Aoj.pojo.dto.ProblemDto;
import com.Aoj.service.ProblemService;
import com.Aoj.service.SearchServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    ProblemService service;


    @Autowired
    SearchServer server;
    @GetMapping("/getProbleAll")
    @ApiOperation("获取问题列表")
    public Result getProbleAll(@RequestParam int page,@RequestParam int size){
        if (page<0){
            return Result.failed("条件错误！");
        }
        return Result.ok(service.getProAll(page,size));
    }

    @GetMapping("/Search")
    public Result SearchProblem(Map<String,String> queryArgent){
        return Result.ok(server.SearchSub(queryArgent));
    }



    @GetMapping("/getProblem")
    @ApiOperation("获取详细数据")
    public Result getProblem(@RequestParam  Integer proid){

        return Result.ok(service.getProblemOne(proid));
    }



    @PostMapping("/upProblem")
    @ApiOperation("修改题目")
    public Result UpProblem(@RequestBody ProblemDto dto){
        dto.setUserid(1);

        if (! service.UpProblyem(dto)){
            return Result.failed("修改失败 请稍后在试试");
        }
        return Result.ok("修改成功");
    }


    @PostMapping("/addPromblem")
    @ApiOperation("添加题目")
    public Result addProblem(@RequestBody ProblemDto dto){
        dto.setUserid(1);
        if (service.AddProblem(dto)){
            return Result.failed("请填写正确的数据");
        }
        return Result.ok("成功");
    }

}
