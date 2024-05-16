package com.test1.controller.query;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author XT
 * @Title: UserInfoQuery
 * @Date: 2024/5/15 23:38
 * @description: 用户详情条件查询
 */
@Data
public class UserInfoQuery {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 当前页数
     */
    @NotNull(message = "页数不能为空")
    private Integer current;

    /**
     * 页面条数
     */
    @NotNull(message = "条数不能为空")
    private Integer size;

}
