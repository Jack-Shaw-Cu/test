package com.test2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author XT
 * @Title: Test2Application
 * @Date: 2024/5/6 23:51
 * @description: test2启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Test2Application {
    public static void main(String[] args) {
        SpringApplication.run(Test2Application.class,args);
    }
}
