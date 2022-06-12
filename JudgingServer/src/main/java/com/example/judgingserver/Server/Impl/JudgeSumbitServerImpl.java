package com.example.judgingserver.Server.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.judgingserver.dto.JudgResultDto;
import com.example.judgingserver.dto.JudgeDatadto;
import com.example.judgingserver.dto.ProblemDto;
import com.example.judgingserver.entity.Recode;
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
    RecodeServiceImpl recodeService;

    @Autowired
    RedisUtils utils;


    @Override
    public JudgResultDto Judge(ProblemDto problemDto) {
        Object qutHash = utils.hashGetOne("JudHash",String.valueOf(problemDto.getPid()));

        JudgeDatadto judgeDatadto = JSONObject.parseObject(qutHash.toString(), JudgeDatadto.class);
        StringBuilder in=new StringBuilder();
        String[] input  = judgeDatadto.getInput();
        for (String s : input) {
            in.append(s);
        }
        StringBuilder ansert=new StringBuilder();
        for (String s : judgeDatadto.getAnswer()) {
            ansert.append(s);
        }
        problemDto.setIn(in.toString());
        problemDto.setAnswer(ansert.toString());
        problemDto.setMemorySize(problemDto.getMemorySize());
        problemDto.setAnswer(problemDto.getAnswer());
        problemDto.setRunTime(problemDto.getRunTime());


        JudgResultDto judgResultDto = super.ExecCoding(problemDto);

        /**
         * 记录数据
         */
        Recode recode=new Recode();
        recode.setUserid(problemDto.getUserid());

        recode.setCode(problemDto.getCode());
        recode.setMemroy(judgResultDto.getMemorySize());
        recode.setRuntime(judgResultDto.getExectime());
        recode.setStatus(judgResultDto.getJudgeStatue());

        recodeService.save(recode);

        return judgResultDto;
    }



}
