package com.test1.controller;

import com.test1.dao.entity.UserDo;
import com.test1.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author XT
 * @Title: Test1Controller
 * @Date: 2024/5/6 18:15
 * @description: Test1Controller
 */
@RestController
@RequestMapping("test1")
public class Test1Controller {

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private int age;

    @Resource
    private UserService userService;


    @GetMapping("num/{id}")
    public Object getNum(@PathVariable String id){
        System.out.println("姓名======" + this.name);
        System.out.println("年龄======" + this.age);

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
