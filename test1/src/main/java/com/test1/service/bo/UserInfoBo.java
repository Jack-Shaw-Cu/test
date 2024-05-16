package com.test1.service.bo;

import com.test1.enums.MyEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author XT
 * @Title: UserInfoBo
 * @Date: 2024/5/14 18:31
 * @description: 用户详情Bo
 */
@Data
public class UserInfoBo {

    @NotNull(message = "姓名不能为空")
    private String name;

    private Integer age;

    private Integer hobbyNumber;

    private MyEnum hobby;
}
