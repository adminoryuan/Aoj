package com.example.judgingserver.Server.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.judgingserver.dto.CompieRequestDto;
import com.example.judgingserver.dto.FeginJudgeDto;;
import com.example.judgingserver.Server.GoJudgServer;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Getter
public enum JudgeCompileEnum {

    JAVA("Java","/usr/bin/javac",new String[]{"main.java", "-o", "a"},"main.java","PATH=/usr/bin:/bin"),
    G加加("C++","/usr/bin/g++",new String[]{"/usr/bin/g++","a.cc", "-o", "a"},"a.cc","PATH=/usr/bin:/bin");

   private String lug;
   private String cpath;
   private String[] arge;
   private String env;
   private String filename;
    private JudgeCompileEnum(String lug,String cpath,String[] args,String filename,String env){
        this.filename=filename;
        this.lug=lug;
        this.cpath=cpath;
        this.arge=args;
        this.env=env;
    }

    @Autowired
    GoJudgServer Jserver;



    public static JudgeCompileEnum CompileEnum( String luange){
        JudgeCompileEnum[] values = values();
        JudgeCompileEnum compileConfig=null;
        for (JudgeCompileEnum value : values) {
            if (value.getLug().equals(luange)){
                compileConfig=value;
                break;
            }
        }
        return compileConfig;

    }


    //{"memory":32714752,"fileIds":{"a":"SEUEMLQM","a.cc":"GEQUB5IR"},"files":{"stdout":"","stderr":""},"time":266854848,"runTime":267860133,"exitStatus":0,"status":"Accepted"}



}
