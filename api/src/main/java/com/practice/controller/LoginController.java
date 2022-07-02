package com.practice.controller;

import com.practice.common.Result;
import com.practice.pojo.Req.LoginReq;
import com.practice.pojo.Req.RegistReq;

import com.practice.pojo.Vo.UserVO;
import com.practice.pojo.dto.Tokendto;
import com.practice.service.AbstSendverCode;
import com.practice.service.UserService;
import com.practice.utils.CheckCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Api(value = "Login", description = "登录注册接口")
@RestController()
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    UserService service;

    @Autowired
    AbstSendverCode sendCodeObj;

    /**
     * 响应一张验证码
     *
     * @param request
     * @param response
     */
    @GetMapping("/VerCode")
    @ApiOperation(value = "返回验证码")
    public void VerCode(HttpServletRequest request,
                        HttpServletResponse response) {
        try {
            response.setStatus(200);

            CheckCodeUtil.WriteVerifyImage(150, 60, response.getOutputStream(), request, 4);

        } catch (IOException e) {

            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }


    /**
     * 发送一封邮件
     *
     * @param email 邮箱
     * @return
     */
    @GetMapping("/sendEmail")

    public Result sendEmial(HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam String Code,
                            @RequestParam String email) {

        HttpSession session = request.getSession();
        if (session.getAttribute("code") == null || !session.getAttribute("code").equals(Code)){
            return Result.failed("请输入正确的验证码");
        }


        if (!VerEmail(email)) {
            return Result.failed("邮箱格式错误");
        }

        String sendCode = sendCodeObj.SendVerCode(email);

        if (sendCode == null) {
            return Result.failed("验证码发送太频繁 请稍后在发送！！");
        }
        session.setAttribute("EmailCode", sendCode);
        session.setAttribute("Email",email);


        return Result.ok("邮件发送成功");
    }


    /**
     * 对邮件进行规则校验
     *
     * @param email
     * @return
     */
    private boolean VerEmail(String email)
    {
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher("dffdfdf@qq.com");
        return matcher.matches();
    }


    @PostMapping("/Sigle")
    public Result Login(@Validated @RequestBody LoginReq data,
                        HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("code") == null || !session.getAttribute("code").equals(data.getCode())) {
            return Result.failed("验证码错误!!");
        }

        session.invalidate();
        UserVO userVO = service.Signel(data);


        if (userVO != null) {

            return Result.ok(0, "登录成功", userVO);
        }
        return Result.failed("账号或者密码错误");
    }


    @PostMapping("/Logout")
    public Result logout(HttpServletRequest request){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Tokendto details1 = (Tokendto)authentication.getPrincipal();

        service.offonline(details1.getUserid());

        return Result.ok("注销成功");
    }

    @PostMapping("/Regist")
    public Result SaveUser(@RequestBody RegistReq user
            , HttpServletRequest req) {
        HttpSession session = req.getSession();

         if (session.getAttribute("EmailCode") == null || !session.getAttribute("EmailCode").toString().split("-")[0].equals(user.getCode())) {
             session.invalidate();
             return Result.failed("请输入正确的验证码");
        }


        if (!user.getEmail().equals(session.getAttribute("Email"))) {
            session.invalidate();
            return Result.failed("年轻人不要胡乱测试！！！");
        }
        session.invalidate();

        if (!service.Regist(user)){
            return Result.failed("注册失败，该用户名已经存在");
        }
        return Result.ok("注册成功");

    }
}
