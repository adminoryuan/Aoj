package com.example.judgingserver.Server.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.judgingserver.Server.GoJudgServer;
import com.example.judgingserver.Server.JudgeExec;
import com.example.judgingserver.dto.CompieRequestDto;
import com.example.judgingserver.dto.ExecDto;
import com.example.judgingserver.dto.ExecRequestDto;
import com.example.judgingserver.dto.FeginJudgeDto;
import com.example.judgingserver.untity.BuildJsonArgs;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JudgeExecImpl implements JudgeExec {
    @Autowired
    GoJudgServer jserver;


    @Override
    public FeginJudgeDto Exec(FeginJudgeDto dto,String in) {
        String fileName = dto.getFilds().keySet().iterator().next();
        String FidId=dto.getFilds().get(fileName);
        CompieRequestDto cRequ = CompieRequestDto.builder()
                .args(BuildJsonArgs.BuildStrArr(fileName))
                .env(BuildJsonArgs.BuildStrArr("PATH=/usr/bin:/bin"))
                .files(BuildJsonArgs.BuildJsonObject(
                        BuildJsonArgs.BuildJsonObject("content", in),
                        BuildJsonArgs.BuildJsonObject("name","stdout","max",10240),
                        BuildJsonArgs.BuildJsonObject("name","stderr","max",10240)
                ))
                .cpuLimit(1000000000l)
                .memoryLimit(104857600l)
                .procLimit(50l)
                .StrictMemoryLimit(false)
                .copyin(BuildJsonArgs.BuildJsonObject(fileName, BuildJsonArgs.BuildJsonObject("fileId", FidId))).build();

        JSONObject jsonObject = BuildJsonArgs.BuildGoOjReqArray(cRequ);

        String res = jserver.run(JSON.toJSONString(jsonObject));

        FeginJudgeDto compileDto = new FeginJudgeDto();

        compileDto.JsonToJudge(res);

        return compileDto;
    }




}
