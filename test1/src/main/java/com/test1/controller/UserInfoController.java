package com.test1.controller;

import com.test1.bean.Result;
import com.test1.controller.query.UserInfoQuery;
import com.test1.controller.query.UserQuery;
import com.test1.controller.vo.UserInfoVo;
import com.test1.dao.entity.UserInfoDo;
import com.test1.service.UserInfoService;
import com.test1.service.bo.UserInfoBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author XT
 * @Title: UserInfoController
 * @Date: 2024/5/14 18:41
 * @description: 用户详情controller
 */
@RestController
@RequestMapping("userInfo")
@Validated
@Api(value = "用户信息",tags = {"用户信息相关接口"})
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;


    @PostMapping("addUserInfo")
    public void addUserInfo(@Valid @RequestBody UserInfoBo userInfoBo){
        this.userInfoService.addUserInfo(userInfoBo);
    }

    @PutMapping("update/{id}")
    @ApiOperation(value = "更新用户详情",notes = "负责人：XT")
    public Result updateUserInfo(@PathVariable Long id,@Valid @RequestBody UserInfoBo userInfoBo){
        try {
            this.userInfoService.updateUserInfo(id,userInfoBo);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        return Result.success("更新成功！");
    }

    @PostMapping("addUserInfoList")
    public void addUserInfoList(@Valid @RequestBody List<UserInfoBo> userInfoBoList){
        this.userInfoService.addUserInfo(userInfoBoList);
    }

    @GetMapping("find/{id}")
    public Result findById(@NotNull @PathVariable Long id){
        UserInfoVo userInfoVo = this.userInfoService.findById(id);
        return Result.success("查询成功",this.userInfoService.findById(id));
    }

    @GetMapping("page")
    @ApiOperation(value = "分页查询",notes = "负责人：XT")
    public Result findByConditionPage(@Valid UserInfoQuery userInfoQuery){
        return Result.success("查询成功",this.userInfoService.findByConditionPage(userInfoQuery));
    }

    @GetMapping("all")
    @ApiOperation(value = "查询所有",notes = "负责人：XT")
    public Result findAll(){
        return Result.success("查询成功",this.userInfoService.findAll());
    }

}
