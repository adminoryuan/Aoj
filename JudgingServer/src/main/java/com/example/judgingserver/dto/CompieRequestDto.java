package com.example.judgingserver.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
/**
 * 请求参数
 */
public class CompieRequestDto {

  String[] args;
  String[] env;
  JSONObject[] files;
  Long cpuLimit;
  Long memoryLimit;
  Long procLimit;

  JSONObject copyin;

  String[] copyOut;

  String[] copyOutCached;

  String copyOutDir;

  boolean StrictMemoryLimit;

};
