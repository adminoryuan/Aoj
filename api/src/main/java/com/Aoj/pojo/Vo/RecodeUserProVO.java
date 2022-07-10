package com.Aoj.pojo.Vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalTime;

/**
 * @author yh
 * @date 2022/6/14 下午6:41
 */
public class RecodeUserProVO  {
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
