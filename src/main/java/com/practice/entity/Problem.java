package com.practice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * newTable
 * </p>
 *
 * @author Vincent
 * @since 2022-06-08 08:57:01
 */
@Getter
@Setter
@TableName("practice_problem")
@ApiModel(value = "Problem对象", description = "newTable")
public class Problem {

    @ApiModelProperty("Primary Key")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("Create Time")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("ProName")
    private String proName;

    @TableField("ProReamke")
    private String proReamke;

    @TableField("sumbitNumber")
    private Integer sumbitNumber;

    @TableField("userid")
    private Integer userid;

    @TableField("ojTime")
    private Integer ojTime;

    @TableField("MemoryTime")
    private Integer memoryTime;

    @TableField("difficulty")
    private Integer difficulty;


}
