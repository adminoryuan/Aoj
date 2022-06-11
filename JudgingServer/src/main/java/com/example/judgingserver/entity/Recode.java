package com.example.judgingserver.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

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
@TableName("ojbase_recode")
public class Recode {

    @TableId(value = "rid", type = IdType.AUTO)
    private Integer rid;

    @TableField("userid")
    private Integer userid;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalTime createTime;

    @TableField("`status`")
    private String status;

    @TableField("Memroy")
    private long memroy;

    @TableField("runtime")
    private long runtime;

    @TableField("`Code`")
    private String code;


}
