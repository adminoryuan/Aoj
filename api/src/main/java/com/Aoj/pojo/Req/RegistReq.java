package com.Aoj.pojo.Req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yh
 * @date 2022/7/2 下午3:28
 */
@Data
public class RegistReq extends LoginReq {

    @NotBlank(message = "请输入邮箱")
    String Email;

    String Phone;

}
