package com.example.judgingserver.Server.Impl;

import com.example.judgingserver.dto.JudgResultDto;
import com.example.judgingserver.dto.ProblemDto;
import com.example.judgingserver.untity.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 用户提交
 * 需要从redis 获取题目数据进行测试
 */
@Service("JudgeSumbitServerImpl")
public class JudgeSumbitServerImpl extends AbstJudgeServer{

    @Autowired
    RedisUtils utils;


    @Override
    public JudgResultDto Judge(ProblemDto problemDto) {
        return  super.ExecCoding(problemDto);
    }

    @Override
    protected boolean JudgeAnsert(String out, ProblemDto anser) {
        return false;
    }

}
