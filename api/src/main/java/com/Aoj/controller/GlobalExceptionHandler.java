package com.Aoj.controller;

import com.Aoj.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yh
 * @date 2022/7/2 下午4:12
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MailException.class)
    public Result result(){
        return Result.failed("邮件发送错误!! 请检查邮箱格式");
    }

    @ExceptionHandler(value = Exception.class)
    public Result ExceptResult(){
        return Result.failed("啊哦！服务需要休息一会。。");
    }
}
