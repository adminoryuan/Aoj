package com.practice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * @since 2022-06-08 09:17:22
 */
@Getter
@Setter
@TableName("practice_user")
@ApiModel(value = "PracticeUser对象", description = "")
public class PracticeUser {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("`password`")
    private String password;

    @TableField("nickname")
    private String nickname;

    @TableField("avatar")
    private String avatar;

    @TableField("sex")
    private String sex;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("email_verified")
    private String emailVerified;

    @TableField("true_name")
    private String trueName;

    @TableField("id_card")
    private String idCard;

    @TableField("birthday")
    private String birthday;

    @TableField("introduction")
    private String introduction;

    @TableField("organization_id")
    private String organizationId;

    @TableField("state")
    private String state;

    @TableField("deleted")
    @TableLogic
    private String deleted;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private String createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private String updateTime;

    @TableField("`ROLE`")
    private String role;


}
