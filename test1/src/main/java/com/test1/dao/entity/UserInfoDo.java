package com.test1.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.test1.enums.MyEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author XT
 * @Title: UserInfo
 * @Date: 2024/5/14 17:53
 * @description: 用户详情
 */
@Data
@TableName(value = "test_user_info",autoResultMap = true)
public class UserInfoDo implements Serializable {

    private static final long serialVersionUID = 6201819776797751864L;

    @TableId(value = "id")
    private Long id;

    @TableField(value = "name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField(value = "hobby")
    private MyEnum hobby;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String hello;

    @TableField(value = "flag")
    private Boolean flag;
}
