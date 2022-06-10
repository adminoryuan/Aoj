package com.practice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:55:13
 */
@Getter
@Setter
@TableName("ojbase_testdata")
@ApiModel(value = "Testdata对象", description = "")
public class Testdata {

    @TableField("id")
    private Integer id;

    @TableField("sid")
    private Integer sid;

    @TableField("input")
    private String input;

    @TableField("answer")
    private String answer;


}
