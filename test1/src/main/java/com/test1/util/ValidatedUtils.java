package com.test1.util;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author XT
 * @Title: ValidatedUtils
 * @Date: 2024/6/1 16:40
 * @description: 验证工具类
 */
public class ValidatedUtils {

    public static Validator getValidator(){
        return VALIDATOR;
    }

    private static final Validator VALIDATOR;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        VALIDATOR = validatorFactory.getValidator();
    }
}
