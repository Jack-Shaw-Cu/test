package com.test2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XT
 * @Title: Test2Controller
 * @Date: 2024/5/6 23:52
 * @description: test2Controller
 */
@RestController
@RequestMapping("test2")
public class Test2Controller {

    @GetMapping("getNum/{id}")
    public String getNum(@PathVariable String id){
        System.out.println("=============" + id);
        return id;
    }
}
