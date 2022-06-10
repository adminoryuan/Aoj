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
 * @since 2022-06-10 20:55:13
 */
@Getter
@Setter
@TableName("ojbase_recode")
@ApiModel(value = "Recode对象", description = "")
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
    private Integer memroy;

    @TableField("runtime")
    private Integer runtime;

    @TableField("`Code`")
    private String code;


}
