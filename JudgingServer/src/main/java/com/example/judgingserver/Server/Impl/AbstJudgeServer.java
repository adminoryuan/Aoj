package com.example.judgingserver.Server.Impl;

import com.example.judgingserver.Server.JudgeCompile;
import com.example.judgingserver.Server.JudgeServer;
import com.example.judgingserver.dto.FeginJudgeDto;
import com.example.judgingserver.dto.JudgResultDto;
import com.example.judgingserver.dto.ProblemDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstJudgeServer implements JudgeServer {
    private static final String Wring="WrongAnswe";
    private static final String Correct="Accpect";
    @Autowired
    JudgeCompile compile;

    @Autowired
    JudgeExecImpl exec;


    @Override
    public   abstract JudgResultDto Judge(ProblemDto problemDto);

    public JudgResultDto ExecCoding(ProblemDto problemDto){
        JudgResultDto result = new JudgResultDto();
        if (JudgeCompileConfig.CompileEnum(problemDto.getCodeLuange()) == null) {

            return result;
        }


        FeginJudgeDto compile = this.compile.Compile(problemDto);

        try {
            if (compile.getStatus().equals("Accepted") && JudgeCompileConfig.CompileEnum(problemDto.getCodeLuange()).isIsRun()) {
                FeginJudgeDto exec = this.exec.Exec(problemDto);
                result.setJudgeStatue(exec.getStatus());
                result.setMemorySize(exec.getMemory());
                result.setExectime(exec.getRunTime());
                result.setStdout(exec.getStdout());
                result.setJudgeBody(exec.getStderr());
            } else {
                result.setJudgeBody(compile.getStderr());
                result.setJudgeStatue(compile.getStatus());
                result.setMemorySize(compile.getMemory());
                result.setExectime(compile.getRunTime());
                result.setStdout(compile.getStdout());
            }


        } catch (Exception e) {


        }

        if (!result.getJudgeStatue().equals("Accepted")){
            return result;
        }


        if (JudgeAnsert(result.getStdout(),problemDto.getAnswer())){
            result.setJudgeStatue(Correct);
        }else {
            result.setJudgeStatue(Wring);
        }
        return result;
    }


    private boolean JudgeAnsert(String out, String Answer) {
        {
            String[] s = out.split(" ");
            String[] s1 = Answer.split(" ");

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
