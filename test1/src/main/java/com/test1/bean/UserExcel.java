package com.test1.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author XT
 * @Title: UserExcel
 * @Date: 2024/6/1 16:04
 * @description: excel解析
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExcel implements Serializable {

    private static final long serialVersionUID = 1216375079102745380L;

    @NotBlank(message = "姓名不能为空")
    @ExcelProperty(value = "用户名",index = 1)
    @Length(min = 2,max = 3,message = "姓名不规范")
    private String name;

    @NotNull(message = "年龄不能为空")
    @ExcelProperty(value = "年龄",index = 2)
    @Min(value = 0)
    @Max(value = 100)
    private Integer age;

}
