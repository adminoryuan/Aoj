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

  String[] arge;
  String[] env;
  JSONObject[] files;
  String cpuLimit;
  String memoryLimit;
  String procLimit;

  JSONObject copyin;

  String[] copyOut;

  String[] copyOutCached;

  String copyOutDir;

};
