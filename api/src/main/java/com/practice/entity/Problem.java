package com.practice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalTime;
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
