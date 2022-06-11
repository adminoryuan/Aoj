package com.example.judgingserver.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Vincent
 * @since 2022-06-10 20:54:03
 */
@Getter
@Setter
@TableName("ojbase_problem")
@ApiModel(value = "Problem对象", description = "")
public class Problem {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("subName")
    private String subName;

    @TableField("subDetailed")
    private String subDetailed;

    @TableField("subLevel")
    private Integer subLevel;

    @TableField("userid")
    private Integer userid;

    @TableField("subMemroy")
    private Integer subMemroy;

    @TableField("subRuntime")
    private Integer subRuntime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalTime createTime;

    @TableField("tag")
    private String tag;


}
