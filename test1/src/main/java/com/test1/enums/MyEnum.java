package com.test1.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @author XT
 * @Title: MyEnum
 * @Date: 2024/5/10 16:55
 * @description: myEnmu
 */
public enum MyEnum implements IEnum<String> {

    /**
     * 红色
     */
    RED(1,"红色"),

    /**
     * 绿色
     */
    GREEN(2,"绿色"),

    /**
     * 黄色
     */
    YELLOW(3,"黄色");

    private final Integer number;

    private final String title;

    MyEnum(Integer number, String title) {
        this.number = number;
        this.title = title;
    }

    @Override
    public String getValue() {
        return this.name();
    }
}
