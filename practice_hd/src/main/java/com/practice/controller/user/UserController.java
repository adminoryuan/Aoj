package com.practice.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.practice.common.Result;
import com.practice.entity.User;
import com.practice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Vincent
 * @since 2022-06-05 21:27:28
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/queryUserPage")
    public Result queryUserPage(@RequestParam(defaultValue = "") String username, @RequestParam(defaultValue = "") Integer current, @RequestParam(defaultValue = "") Integer size) {
        IPage iPage = new Page(current, size);
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StringUtils.isNotEmpty(username)) {
            queryWrapper.eq("username", username);
        }
        userService.page(iPage, queryWrapper);
        return Result.ok(iPage);
    }



    @GetMapping("/Test2")
    @PreAuthorize("hasAnyRole('USER')")
    public String USER(){
        return "亲爱的管理员";
    }

    @GetMapping("/Test1")
    public String getTest1(){
        return "asdasd";
    }


}