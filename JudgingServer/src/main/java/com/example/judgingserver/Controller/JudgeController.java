package com.example.judgingserver.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.judgingserver.Server.Impl.AbstJudgeServer;
import com.example.judgingserver.Server.JudgeServer;
import com.example.judgingserver.comon.Result;
import com.example.judgingserver.dto.JudgResultDto;
import com.example.judgingserver.dto.ProblemDto;
import com.example.judgingserver.dto.Tokendto;
import com.example.judgingserver.untity.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Judge接口
 */
@RestController
public class JudgeController {
    @Autowired
    @Qualifier("JudgeSumbitServerImpl")
    AbstJudgeServer SumbitServer;


    @Autowired
    @Qualifier("JudgeSelfServer1")
    AbstJudgeServer SelfServer;

    @Autowired
    RedisUtils untity;
    /**
     * 自测接口
     * @param problem
     * @return
     */
    @PostMapping("/SlftJudge")
    public Result Judge( @RequestBody ProblemDto problem){



        JudgResultDto judge = SelfServer.Judge(problem);

        if (judge==null){
            return Result.failed(10001,"服务器错误",judge);
        }
        return Result.ok(judge);
    }

    @GetMapping("/app")
    public String getJUdge(){
        return "asdasd";
    }

    @PostMapping("/SubJudge")
    public Result JudgeSubmit(HttpServletRequest request,@RequestBody ProblemDto problemDto){
        String token = request.getHeader("token");

        Object o = untity.get(token);

        if (o==null){
            return Result.failed("请先登录");
        }

        Tokendto logindto = JSONObject.parseObject(o.toString(), Tokendto.class);

        problemDto.setUserid(logindto.getUserid());

        JudgResultDto judge = SumbitServer.Judge(problemDto);

        if (judge==null){
            return Result.failed(10001,"服务器错误",judge);
        }
        return Result.ok(judge);
    }
}
