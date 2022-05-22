package com.myz.azloanmanage.util;


import lombok.Data;

import java.io.Serializable;

/**
 * 返回前端数据
 */
@Data
public class Result implements Serializable {

    /**
     * 响应状态码
     */
    private int code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 响应数据
     */
    private Object data;

    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回
     * @param message
     * @param data
     * @return
     */
    public static Result success(String message,Object data){
        return new Result(200,message,data);
    }

    /**
     * 失败返回
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static Result fail(int code,String message,Object data){
        return new Result(code,message,data);
    }

    /**
     * 失败返回
     * @param code
     * @param message
     * @return
     */
    public static Result fail(int code,String message){
        return new Result(code,message);
    }

}
