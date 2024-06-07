package com.test1.controller;

import com.test1.annotation.MyAnnotation;
import com.test1.bean.Result;
import com.test1.dao.entity.UserDo;
import com.test1.feign.Test2Feign;
import com.test1.service.UserService;
import com.test1.service.bo.UserBo;
import com.test1.service.bo.UserInfoBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;

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
@Validated
@Api(value = "testController",tags = {"test1测试接口"})
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
    public void save(@Valid @RequestBody UserBo userBo){
        this.userService.addUser(userBo);
    }

    @GetMapping("findAll")
    public Result findAll(){
        return Result.success("查询成功！",this.userService.findAll());
    }

    @GetMapping("test")
    public void test(){
        MyAnnotation annotation = UserDo.class.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.min() + "-------------");
        System.out.println(annotation.max() + "==============");
        System.out.println(annotation.sex().toString());
    }

   @GetMapping("two")
    public Result testTwo(UserBo userBo, UserInfoBo userInfoBo){
        System.out.println(userBo);
        System.out.println(userInfoBo);
        return Result.success("成功");
    }

    @GetMapping("stop")
    @ApiOperation(value = "阻塞测试",notes = "负责人：XT")
    public Result testStop(@Valid @NotBlank(message = "stopName不能为空") String stopName){
        System.out.println("-----------------------进来了" + stopName);
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("------------" + i + "秒");
                Thread.sleep(1000);
            }
            System.out.println("------完了----------" + stopName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.success("成功");
    }

    @PostMapping("array")
    public Result arrayTest(@RequestBody String[] ids){
        System.out.println(Arrays.toString(ids));
        return Result.success("成功了!");
    }

    @PostMapping("importExcel")
    @ApiOperation(value = "excel导入",notes = "负责人：XT")
    public Result importExcel(@RequestParam("file")MultipartFile file){
        return Result.success("导入成功！",this.userService.importExcel(file));
    }

    @GetMapping("findById/{id}")
    @ApiOperation(value = "通过id查询用户", notes = "负责人：XT")
    public Result findById(@PathVariable Long id){
        return Result.success("查询成功！",this.userService.findById(id));
    }

}
