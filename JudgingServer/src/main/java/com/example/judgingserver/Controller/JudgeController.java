package com.example.judgingserver.Controller;

import com.example.judgingserver.Server.Impl.AbstJudgeServer;
import com.example.judgingserver.Server.JudgeServer;
import com.example.judgingserver.comon.Result;
import com.example.judgingserver.dto.JudgResultDto;
import com.example.judgingserver.dto.ProblemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    /**
     * 自测接口
     * @param problem
     * @return
     */
    @PostMapping("/SlftJudge")
    public Result Judge(@RequestBody ProblemDto problem){
        JudgResultDto judge = SelfServer.Judge(problem);

        if (judge==null){
            return Result.failed(10001,"服务器错误",judge);
        }
        return Result.ok(judge);
    }


    @PostMapping("/SubJudge")
    public Result JudgeSubmit(@RequestBody ProblemDto problemDto){
        JudgResultDto judge = SumbitServer.Judge(problemDto);

        if (judge==null){
            return Result.failed(10001,"服务器错误",judge);
        }
        return Result.ok(judge);
    }
}
