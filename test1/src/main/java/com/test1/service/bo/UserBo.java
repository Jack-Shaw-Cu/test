package com.test1.service.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author XT
 * @Title: UserBo
 * @Date: 2024/5/10 16:30
 * @description: 用户bo
 */
@Data
@ApiModel(description = "用户信息")
public class UserBo {

    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "游戏")
    private List<String> game;
}
