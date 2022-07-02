package com.practice.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.entity.Problem;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProblemDto extends Problem {

    @NotBlank(message = "题目id不为空")
    @JsonProperty(value = "Pid")
    private Integer id;

    @NotBlank(message = "题目名称不为空")
    @JsonProperty("proName")
    String subName;

    @NotBlank(message = "")
    @JsonProperty("subDetailed")
    String subDetailed;

    @NotNull
    @JsonProperty("subLevel")
    Integer subLevel;

    @NotNull
    @JsonProperty("subMemroy")
    Integer subMemroy;

    @NotNull
    @JsonProperty("subRuntime")
    Integer subRuntime;

    @NotNull
    @JsonProperty("create_time")
    Date create_time;

    @NotBlank
    @JsonProperty("tag")
    String tag;

    @NotNull
    @JsonProperty("input")
    String[] input;

    @NotNull
    @JsonProperty("Anser")
    String[] Answer;



}
