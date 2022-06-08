package com.example.judgingserver.Server.Impl;

import com.example.judgingserver.Server.JudgeServer;
import com.example.judgingserver.dto.JudgResult;
import com.example.judgingserver.dto.ProblemDto;
import com.example.judgingserver.untity.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JudgeServerImpl implements JudgeServer {
    @Autowired
    JudgeCompileEnum compile;

    @Autowired
    JudgeExecImpl exec;


    @Autowired
    RedisUtils utils;

    @Override
    public JudgResult Judge(ProblemDto problemDto) {

        return null;
    }
}
