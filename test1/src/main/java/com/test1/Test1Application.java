package com.test1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author XT
 * @Title: Test1Application
 * @Date: 2024/5/6 18:12
 * @description: test1启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.test1.dao")
public class Test1Application {
    public static void main(String[] args) {
        SpringApplication.run(Test1Application.class,args);
    }
}
