package com.test1.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.test1.enums.MyEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author XT
 * @Title: UserInfo
 * @Date: 2024/5/14 17:53
 * @description: 用户详情
 */
@Data
@TableName("test_user_info")
public class UserInfoDo implements Serializable {

    private static final long serialVersionUID = 6201819776797751864L;

    @TableId(value = "id")
    private Long id;

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("hobby")
    private MyEnum hobby;
}
