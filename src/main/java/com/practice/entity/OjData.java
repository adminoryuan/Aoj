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
 * practice_ojData
 * </p>
 *
 * @author Vincent
 * @since 2022-06-08 08:53:06
 */
@Getter
@Setter
@TableName("practice_ojData")
@ApiModel(value = "OjData对象", description = "practice_ojData")
public class OjData {

    @ApiModelProperty("Primary Key")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("Create Time")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("inputData")
    private String inputData;

    @TableField("outputData")
    private String outputData;

    @TableField("`type`")
    private Integer type;

    @TableField("proid")
    private Integer proid;


}
