package com.example.judgingserver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.judgingserver.Server.JudgeServer;
import com.example.judgingserver.Server.GoJudgServer;
import com.example.judgingserver.dto.ProblemDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JudgingServerApplicationTests {

    @Autowired
    GoJudgServer server;
    @Test
    void contextLoads() {
        String body=" {\n" +
                "    \"cmd\": [\n" +
                "        {\n" +
                "            \"args\": [\n" +
                "                \"/usr/bin/g++\", \n" +
                "                \"a.cc\", \n" +
                "                \"-o\", \n" +
                "                \"a\"\n" +
                "            ], \n" +
                "            \"env\": [\n" +
                "                \"PATH=/usr/bin:/bin\"\n" +
                "            ], \n" +
                "            \"files\": [\n" +
                "                {\n" +
                "                    \"content\": \"\"\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"name\": \"stdout\", \n" +
                "                    \"max\": 10240\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"name\": \"stderr\", \n" +
                "                    \"max\": 10240\n" +
                "                }\n" +
                "            ], \n" +
                "            \"cpuLimit\": 10000000000, \n" +
                "            \"memoryLimit\": 104857600, \n" +
                "            \"procLimit\": 50, \n" +
                "            \"copyIn\": {\n" +
                "                \"a.cc\": {\n" +
                "                  \"content\": \"#include <iostream>\\nusing namespace std;\\nint main() {\\nint a, b;\\ncin >> a >> b;\\ncout << a + b << endl;\\n}\"\n" +
                "                }\n" +
                "            }, \n" +
                "            \"copyOut\": [\n" +
                "                \"stdout\", \n" +
                "                \"stderr\"\n" +
                "            ], \n" +
                "            \"copyOutCached\": [\n" +
                "                \"a.cc\", \n" +
                "                \"a\"\n" +
                "            ], \n" +
                "            \"copyOutDir\": \"1\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";
        String result = server.run(body);

        JSONArray objects =JSON.parseArray(result);
        JSONObject jsonObject = JSON.parseObject(objects.get(0).toString());
        System.out.println(objects.get(0));
        System.out.println(jsonObject.get("status"));


      //  CompieDto o =JSON.parseObject(Jarr.get(0).toString(),CompieDto.class);



        //System.out.println(o.toString());

    }
    public JSONObject buildJsonObject(String key,Object val){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,val);
        return jsonObject;
    }

    @Autowired
    JudgeServer jserver;
    @Test
    public void TestJSon(){
        ProblemDto dto=new ProblemDto();
        dto.setCodeLuange("Java");
        dto.setCode("public class main{\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"hello\");\n" +
                "    }\n" +
                "}");
        jserver.Judge(dto);
    }

}

