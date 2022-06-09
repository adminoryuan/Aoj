package com.example.judgingserver.Server.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.judgingserver.Server.GoJudgServer;
import com.example.judgingserver.Server.JudgeCompile;
import com.example.judgingserver.Server.JudgeServer;
import com.example.judgingserver.dto.CompieRequestDto;
import com.example.judgingserver.dto.FeginJudgeDto;
import com.example.judgingserver.dto.ProblemDto;
import com.example.judgingserver.untity.BuildJsonArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.stereotype.Component;

@Component
public class JudgeCompileImpl implements JudgeCompile {

    @Autowired
    GoJudgServer Jserver;
    @Override
    public FeginJudgeDto Compile(ProblemDto problem) {

        JudgeCompileEnum compileConfig=JudgeCompileEnum.CompileEnum(problem.getCodeLuange());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("","");
        CompieRequestDto build = CompieRequestDto.builder()
                .args(compileConfig.getArge())
                .env(new String[]{compileConfig.getEnv()})
                .files(BuildJsonArgs.BuildJsonObject(
                        buildJsonObject("content", ""),
                        BuildJsonArgs.BuildJsonObject("name","stdout","max",10240),
                        BuildJsonArgs.BuildJsonObject("name","stderr","max",10240)
                ))
                .cpuLimit(10000000000l)
                .memoryLimit(104857600l)
                .procLimit(50l)
                .copyin(buildJsonObject(compileConfig.getFilename(), buildJsonObject("content", problem.getCode())))
                .copyOut(new String[]{"stdout", "stderr"})
                .copyOutCached(new String[]{ compileConfig.getFilename(),"a" })
                .copyOutDir("1").build();


        JSONObject objects = BuildJsonArgs.BuildGoOjReqArray(build);
        System.out.println(JSON.toJSONString(objects));
        String compileRes = Jserver.run(JSON.toJSONString(objects));

        System.out.println(compileRes);
        FeginJudgeDto compileDto = new FeginJudgeDto();
        if (!compileDto.JsonToJudge(compileRes)){
            return null;
        }

        return compileDto;
    }
    public JSONObject buildJsonObject(String key,Object val){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,val);
        return jsonObject;
    }
}
