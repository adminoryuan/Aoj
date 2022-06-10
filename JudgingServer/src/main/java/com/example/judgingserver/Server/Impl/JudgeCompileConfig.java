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
public enum JudgeCompileConfig {

    JAVA(false,"Java","/usr/bin/java",new String[]{"/usr/bin/java","main.java"},"main.java","PATH=/usr/bin:/bin",new String[]{"main.java"}),

    CPP(true,"C++","/usr/bin/g++",new String[]{"/usr/bin/g++","a.cc", "-o", "a"},"a.cc","PATH=/usr/bin:/bin",new String[]{"a","a.cc","a"}),

    Python(false,"Python3","/usr/bin/python3",new String[]{"/usr/bin/python3","a.py"},"a.py","PATH=/usr/bin:/bin",new String[]{"a.py"}),

    C(true,"C","/usr/bin/gcc",new String[]{"/usr/bin/gcc","test.c","-o","c.out"},"test.c","PATH=/usr/bin:/bin",new String[]{"c.out","test.c"});

   private String lug;
   private String cpath;
   private String[] arge;
   private String env;
   private String filename;
   private boolean IsRun;
   private String[] chche;
    private JudgeCompileConfig(boolean IsRun,String lug,String cpath,String[] args,String filename,String env,String[] Cache){
        this.filename=filename;
        this.IsRun=IsRun;
        this.chche=Cache;
        this.lug=lug;
        this.cpath=cpath;
        this.arge=args;
        this.env=env;
    }

    @Autowired
    GoJudgServer Jserver;



    public static JudgeCompileConfig CompileEnum( String luange){
        JudgeCompileConfig[] values = values();
        JudgeCompileConfig compileConfig=null;
        for (JudgeCompileConfig value : values) {
            if (value.getLug().equals(luange)){
                compileConfig=value;
                break;
            }
        }
        return compileConfig;

    }


    //{"memory":32714752,"fileIds":{"a":"SEUEMLQM","a.cc":"GEQUB5IR"},"files":{"stdout":"","stderr":""},"time":266854848,"runTime":267860133,"exitStatus":0,"status":"Accepted"}



}
