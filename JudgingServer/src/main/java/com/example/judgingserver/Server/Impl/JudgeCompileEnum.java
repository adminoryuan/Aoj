package com.example.judgingserver.Server.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.judgingserver.dto.CompieRequestDto;
import com.example.judgingserver.dto.CompileDto;
import com.example.judgingserver.Server.GoJudgServer;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public enum JudgeCompileEnum {

    JAVA("Java","/usr/bin/java","main.java -o mian.class","PATH=/usr/bin:/bin"),
    G加加("C++","/user/bin/g++","a.cc -o a","PATH=/usr/bin:/bin");

    String _lug;
    String _cpath;
    String _arge;
    String _env;

    private JudgeCompileEnum(String lug,String cpath,String args,String env){
        _lug=lug;
        _cpath=cpath;
        _arge=args;
        _env=env;
    }

    @Autowired
    GoJudgServer Jserver;

    public String getLug(){
        return _lug;
    }

    public CompileDto Compile(String code, String luange){
        JudgeCompileEnum[] values = values();
        JudgeCompileEnum compileConfig=null;
        for (JudgeCompileEnum value : values) {
            if (value.getLug().equals(luange)){
                compileConfig=value;
                break;
            }
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("","");
        CompieRequestDto build = CompieRequestDto.builder()
                .arge(new String[]{compileConfig.get_cpath(), compileConfig.get_arge()})
                .env(new String[]{compileConfig.get_env()})
                .files(new JSONObject[]{buildJsonObject("content", ""), buildJsonObject("name", "stdout")})
                .cpuLimit("10000000000")
                .memoryLimit("104857600")
                .procLimit("50")
                .copyin(buildJsonObject("a.cc", buildJsonObject("content", code)))
                .copyOut(new String[]{"stdout", "stderr"})
                .copyOutCached(new String[]{"a.cc", "a"})
                .copyOutDir("1").build();

        String Req = JSON.toJSONString(build);

        String compileRes = Jserver.run(Req);
        CompileDto compileDto = new CompileDto();
        if (compileDto.JsonToJudge(compileRes)){
            return null;
        }

        return compileDto;
    }

    public JSONObject buildJsonObject(String key,Object val){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,val);
        return jsonObject;
    }
    //{"memory":32714752,"fileIds":{"a":"SEUEMLQM","a.cc":"GEQUB5IR"},"files":{"stdout":"","stderr":""},"time":266854848,"runTime":267860133,"exitStatus":0,"status":"Accepted"}



}
