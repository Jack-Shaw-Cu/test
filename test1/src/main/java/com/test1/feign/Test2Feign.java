package com.test1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author XT
 * @Title: Test2Feign
 * @Date: 2024/5/11 16:40
 * @description: test2Feign
 */
@FeignClient(name = "test2")
public interface Test2Feign {

    @GetMapping("test2/getNum/{id}")
    public String getNum(@PathVariable String id);

}