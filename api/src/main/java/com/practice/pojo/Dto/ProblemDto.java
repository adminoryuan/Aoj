package com.practice.pojo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.entity.Problem;
import lombok.Data;

import java.util.Date;

@Data
public class ProblemDto extends Problem {
    @JsonProperty("proName")
    String proName;

    @JsonProperty("subDetailed")
    String subDetailed;

    @JsonProperty("subLevel")
    Integer subLevel;

    @JsonProperty("subMemroy")
    Integer subMemroy;

    @JsonProperty("subRuntime")
    Integer subRuntime;

    @JsonProperty("create_time")
    Date create_time;


    @JsonProperty("tag")
    String tag;

    @JsonProperty("input")
    String[] input;

    @JsonProperty("Anser")
    String[] Answer;



}
