package com.practice.common;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Result {
    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result ok(int code, String message, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setData(data);
        r.setMessage(message);
        return r;
    }
    public static Result ok() {
        Result r = new Result();
        r.setCode(0);
        return r;
    }
    public static Result ok(String message) {
        Result r = new Result();
        r.setCode(0);
        r.setMessage(message);
        return r;
    }
    public static Result ok(Object data) {
        Result r = new Result();
        r.setCode(0);
        r.setData(data);
        return r;
    }
    public static Result failed(int code, String message, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setData(data);
        r.setMessage(message);
        return r;
    }
    public static Result failed() {
        Result r = new Result();
        r.setCode(1);
        return r;
    }
    public static Result failed(String message) {
        Result r = new Result();
        r.setMessage(message);
        r.setCode(1);
        return r;
    }
    public static Result failed(Object data) {
        Result r = new Result();
        r.setData(data);
        return r;
    }
}
