package com.Aoj.controller;

import com.Aoj.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yh
 * @date 2022/7/10 下午12:41
 */
@RestController
public class SearchController {
    @GetMapping("/search/Subject")


    public Result searchSub(){
        return Result.failed();
    }

}
