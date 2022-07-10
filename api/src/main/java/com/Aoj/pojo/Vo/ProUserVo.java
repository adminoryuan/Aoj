package com.Aoj.pojo.Vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class ProUserVo {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("subName")
    private String subName;

    @TableField("subDetailed")
    private String subDetailed;

    @TableField("subLevel")
    private Integer subLevel;

    @TableField("Name")
    private String Name;

    @TableField("subMemroy")
    private Integer subMemroy;

    @TableField("subRuntime")
    private Integer subRuntime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalTime createTime;

    @TableField("tag")
    private String tag;

}
