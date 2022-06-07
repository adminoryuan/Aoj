package com.practice.controller;

import com.practice.common.Result;
import com.practice.dto.Userdto;
import com.practice.entity.User;
import com.practice.service.user.AbstSendverCode;
import com.practice.service.user.UserService;
import com.practice.utils.CheckCodeUtil;
import com.sun.org.apache.bcel.internal.generic.I2F;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Api(value = "Login" ,description = "登录注册接口")
@RestController()
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    UserService service;

    @Autowired
    AbstSendverCode sendCodeObj;


    /**
     * 响应一张验证码
     * @param request
     * @param response
     */
    @GetMapping("/VerCode")
    @ApiOperation(value = "返回验证码")
    public void VerCode(HttpServletRequest request,
                        HttpServletResponse response){
        try {
            response.setStatus(200);

            CheckCodeUtil.WriteVerifyImage(150, 60, response.getOutputStream(),request, 4);

        } catch (IOException e) {

            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }


    /**
     * 发送一封邮件
     * @param email 邮箱
     * @return
     */
    @GetMapping("/sendEmail")
    public Result sendEmial(HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam String Code,
                            @RequestParam String email) {

        HttpSession session = request.getSession();

//
        if(session.getAttribute("EmailCode")!=null){
            return Result.failed("验证码发送太频繁 请稍后在发送！！");
        }

        if (session.getAttribute("code")==null || !session.getAttribute("code").equals(Code)){
            return Result.failed("请输入正确的验证码");
        }


        if (!VerEmail(email)){
            return Result.failed("邮箱格式错误");
        }

        //将发送的验证码写入session
        String sendCode = sendCodeObj.Send(email);

        session.setAttribute("EmailCode",sendCode+"-"+email);

        session.setMaxInactiveInterval(6);//设置60 秒过期

        return Result.ok("邮件发送成功");
    }


    /**
     * 对邮件进行规则校验
     * @param email
     * @return
     */
    private boolean VerEmail(String email){
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher("dffdfdf@qq.com");
        return matcher.matches();
    }



    @PostMapping("/Login")
    public Result Login(@Validated @RequestBody Userdto data,
                        HttpServletRequest request){
        HttpSession session = request.getSession();

         if (session.getAttribute("code")==null ||!session.getAttribute("code").equals(data.getCode())){
             return Result.failed("验证码错误!!");
         }

        String token = service.Login(data);

         if (token!=null) {
            return Result.ok(200,"登录成功",token);
        }
        return Result.failed("账号或者密码错误");
    }


    @PostMapping("/Regist")
    public Result SaveUser(@RequestBody Userdto user
                           ,HttpServletRequest req) {
        HttpSession session = req.getSession();

        System.out.println(session.getAttribute("EmailCode").toString());
        if (session.getAttribute("EmailCode")==null||! session.getAttribute("EmailCode").toString().split("-")[0].equals(user.getCode())){
            return Result.failed("请输入正确的验证码");
        }

      if (!user.getUsername().equals(session.getAttribute("EmailCode").toString().split("-")[1])){
            return Result.failed("年轻人不要胡乱测试！！！");
        }

        boolean register = service.register(user);
        if (!register) {
            return Result.failed("该用户已被注册");
        }
        return Result.ok("注册成功");

    }
}
