package com.example.judgingserver.Server.Impl;

import com.example.judgingserver.Server.JudgeCompile;
import com.example.judgingserver.Server.JudgeServer;
import com.example.judgingserver.dto.ExecDto;
import com.example.judgingserver.dto.FeginJudgeDto;
import com.example.judgingserver.dto.JudgResult;
import com.example.judgingserver.dto.ProblemDto;
import com.example.judgingserver.untity.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JudgeServerImpl implements JudgeServer {

    @Autowired
    JudgeCompile compile;


    @Autowired
    JudgeExecImpl exec;

    @Autowired
    RedisUtils utils;

    @Override
    public JudgResult Judge(ProblemDto problemDto) {

        FeginJudgeDto compile = this.compile.Compile(problemDto);

        JudgResult result=new JudgResult();
        if (compile.getStatus().equals("Accepted")){
            FeginJudgeDto exec = this.exec.Exec(compile);
            result.setStatue(exec.getStatus());
            result.setMemorySize(exec.getMemory());
            result.setExectime(exec.getRunTime());
            result.setStdout(exec.getStdout());

        }

        return result;
    }
}
