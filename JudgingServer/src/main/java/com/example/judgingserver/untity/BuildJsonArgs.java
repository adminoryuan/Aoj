package com.example.judgingserver.untity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public  class BuildJsonArgs {
    public static JSONObject BuildJsonObject(String key, Object val){
        JSONObject json= new JSONObject();
        json.put(key,val);
        return json;
    }
    public static JSONObject BuildJsonObject(String key,Object val,String Key1,Object val1){
        JSONObject json= new JSONObject();
        json.put(key,val);
        json.put(Key1,val1);
        return json;
    }
    public static JSONObject BuildGoOjReqArray(Object build){
        JSONArray BodyArray = new JSONArray();

        BodyArray.add(build);

        JSONObject ReqAegs = new JSONObject();

        ReqAegs.put("cmd",BodyArray);
        return ReqAegs;
    }
    public static JSONObject[] BuildJsonObject(JSONObject... data){
        return data;
    }
    public static String[] BuildStrArr(String... arg){
        return arg;
    }
}
