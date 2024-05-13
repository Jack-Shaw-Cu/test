package com.test1.controller;

import com.test1.dao.entity.UserDo;
import com.test1.feign.Test2Feign;
import com.test1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author XT
 * @Title: Test1Controller
 * @Date: 2024/5/6 18:15
 * @description: Test1Controller
 */
@Slf4j
@RestController
@RequestMapping("test1")
@RefreshScope
public class Test1Controller {

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private int age;

    @Resource
    private UserService userService;

    @Resource
    private Test2Feign test2Feign;

    @GetMapping("num/{id}")
    public Object getNum(@PathVariable String id){
        System.out.println("姓名======" + this.name);
        System.out.println("年龄======" + this.age);
        this.test2Feign.getNum(id);
        return id;
    }

    @PostMapping("save")
    public void save(@RequestBody UserDo userDo){
        this.userService.addUser(userDo);
    }

    @GetMapping("findAll")
    public void findAll(){
        System.out.println(this.userService.findAll());
    }



}
