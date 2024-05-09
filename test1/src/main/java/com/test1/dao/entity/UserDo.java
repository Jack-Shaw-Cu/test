package com.test1.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author XT
 * @Title: User
 * @Date: 2024/5/8 17:31
 * @description: 用户
 */
@Data
@TableName("test_user")
public class UserDo {

    @TableId(value = "id")
    private Long id;

    @TableField("name")
    private String name;
}
