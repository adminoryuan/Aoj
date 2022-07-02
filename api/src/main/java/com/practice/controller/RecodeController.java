package com.practice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.practice.common.Result;
import com.practice.entity.Recode;
import com.practice.pojo.dto.Tokendto;
import com.practice.service.RecodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:55:13
 */
@RestController
@RequestMapping("/recode")
@PreAuthorize("hasRole('USER')||hasRole('ADMIN')")
@Api("提交记录")
public class RecodeController {

    @Autowired
    RecodeService service;
    @GetMapping("/getThenRecode")
    @ApiOperation("获取提交记录")
    public Result getThenRecord(@RequestParam int pid){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Tokendto details1 = (Tokendto)authentication.getPrincipal();
        System.out.println(details1.getUserid());
        return Result.ok(service.list(new QueryWrapper<Recode>().eq("userid",details1.getUserid()).eq("qid",pid)));
    }

}
