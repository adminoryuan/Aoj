package com.example.judgingserver.Server.Impl;

import com.example.judgingserver.Server.JudgeCompile;
import com.example.judgingserver.Server.JudgeServer;
import com.example.judgingserver.dto.FeginJudgeDto;
import com.example.judgingserver.dto.JudgResultDto;
import com.example.judgingserver.dto.ProblemDto;
import com.example.judgingserver.untity.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 用户自测
 */
@Service("JudgeSelfServer1")
public class JudgeSelfServerImpl extends AbstJudgeServer {


    @Override
    public JudgResultDto Judge(ProblemDto problemDto) {
        return super.ExecCoding(problemDto);
    }

    @Override
    protected boolean JudgeAnsert(String out, ProblemDto problem) {
        {
            if (problem.getAnswer()==null){
                problem.setAnswer("");
            }
            String[] s = out.split(" ");
            String[] s1 = problem.getAnswer().split(" ");

            if (s.length!=s1.length)return false;

            int index=0;

            while (index<s.length){
                if (!s[index].equals(s1[index])) return false;
                index++;
            }
            return true;
        }
    }
}
