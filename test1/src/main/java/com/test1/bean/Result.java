package com.test1.bean;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author XT
 * @Title: Result
 * @Date: 2024/5/14 22:50
 * @description: 统一封装返回对象
 */
@Slf4j
@Builder
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 2367377191528016198L;

    /**
     * 编码
     */
    private final String code;

    /**
     * 信息
     */
    private final String message;

    /**
     * 返回业务数据
     */
    private final Object data;

    /**
     * 私有化构造方法
     * @param code
     * @param message
     * @param data
     */
    private Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result fail(String message){
        return new ResultBuilder().code("0").message(message).build();
    }

    public static Result success(String message,Object data){
        return new ResultBuilder().code("1").message(message).data(data).build();
    }

}
