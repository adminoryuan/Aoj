package com.example.judgingserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("ojbase_Judgedata")
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
