package com.test1.service.bo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.test1.enums.MyEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author XT
 * @Title: UserInfoBo
 * @Date: 2024/5/14 18:31
 * @description: 用户详情Bo
 */
@Data
@ApiModel(description = "用户详情Bo")
public class UserInfoBo {

    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "爱好-发送类型(1/2/3)")
    private Integer hobbyNumber;

    @ApiModelProperty(value = "爱好")
    private MyEnum hobby;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "hello")
    private String hello;

    @ApiModelProperty(value = "是否")
    private Boolean flag;
}
