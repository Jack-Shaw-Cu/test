package com.test1.config;

import com.test1.bean.BizException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author XT
 * @Title: MyExceptionHandler
 * @Date: 2024/6/5 20:46
 * @description: 全局异常处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public String bizExceptionHandler(BizException e){
        System.out.println("--------------------");
        return "一场来了--->" + e.getMessage();
    }
}
