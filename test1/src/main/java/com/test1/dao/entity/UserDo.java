package com.test1.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.test1.annotation.MyAnnotation;
import com.test1.config.ListTypeHandler;
import lombok.Data;

import java.util.List;

/**
 * @author XT
 * @Title: User
 * @Date: 2024/5/8 17:31
 * @description: 用户
 */
@Data
@TableName(value = "test_user",autoResultMap = true)
@MyAnnotation(min = 25,max = 55,sex = MyAnnotation.SEX_TYPE.WOMAN)
public class UserDo {

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("name")
    private String name;

    @TableField(value = "game",typeHandler = ListTypeHandler.class)
    private List<String> game;
}
