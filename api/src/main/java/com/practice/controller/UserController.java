package com.practice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.practice.common.Result;
import com.practice.entity.User;
import com.practice.pojo.Vo.UserOnLineVO;
import com.practice.service.UserService;
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
 * @since 2022-06-10 20:55:13
 */
@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    @Autowired
    UserService service;


    @GetMapping("/getUserAll")
    public Result getUserAll(@RequestParam int page,@RequestParam int size){
       return Result.ok(service.getUserAll(page,size));
    }

    @PostMapping("/del")
    public Result delUser(@RequestParam int id){
        if (service.remove(new QueryWrapper<User>().eq("id", id))){
            return Result.failed("用户不存在或服务器发送了错误 请稍后再试试");
        }
        return Result.ok("删除成功！");
    }
    @PostMapping("Insert")
    public Result AddUser(@RequestBody User user){
        if (!service.save(user)){
            return Result.failed("添加失败，请稍后再试试");
        }
        return Result.ok("添加成功！！");
    }

    @PostMapping("/Update")
    public Result UpdateUser(@RequestBody User user){
        if (!service.updateById(user)){
            return Result.failed("删除失败");
        }
        return Result.ok("删除成功");
    }

    @PostMapping("/OffOnline")
    @ApiOperation("下线指定用户")
    public Result OffOnline(@RequestParam int userId){
        if (!service.offonline(userId)){
            return Result.failed("非法的操作");
        }
        return Result.ok("操作成功");
    }

}
