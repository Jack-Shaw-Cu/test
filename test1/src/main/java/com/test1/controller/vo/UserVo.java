package com.test1.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author XT
 * @Title: UserVo
 * @Date: 2024/5/9 19:03
 * @description: 用户Vo
 */
@Data
@ApiModel(description = "用户返回")
public class UserVo {

   @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "游戏")
    private List<String> game;
}
