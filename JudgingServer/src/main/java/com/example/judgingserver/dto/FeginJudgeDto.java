package com.example.judgingserver.dto;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class FeginJudgeDto {


     String status;

     String exitStatus;

     long  time;

     long memory;

     long runTime;

     String stderr;

     String stdout;
     Map<String,String> Filds;
    /**
     * 传入一个json 字符串返回一个judage对象
     * @param json
     * @return
     */
    public  boolean JsonToJudge(String json){
        try {

            JSONArray objects = JSON.parseArray(json);

            JSONObject parse = JSON.parseObject(objects.get(0).toString());

            this.exitStatus=parse.getString("exitStatus");

            this.status=parse.getString("status");
            this.runTime=parse.getLong("runTime");
            this.memory= parse.getLong("memory");

            JSONObject files = JSON.parseObject(parse.getString("files"));

            this.stdout=files.getString("stdout");

            this.stderr=files.getString("stderr");

            this.Filds=JSON.parseObject(parse.getString("fileIds"),new HashMap<String,String>().getClass());

        }
        catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
        return true;
    }
}
