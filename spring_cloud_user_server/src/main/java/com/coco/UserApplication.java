package com.coco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangxiaoxun
 * @date 2018/12/8  19:10
 **/
@SpringBootApplication
@EnableDiscoveryClient   //将服务节点注册到eureka server上
public class UserApplication {
    public static void main(String[] args){
        SpringApplication.run(UserApplication.class, args);
    }
}
