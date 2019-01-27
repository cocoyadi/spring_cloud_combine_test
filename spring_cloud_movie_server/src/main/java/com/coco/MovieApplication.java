package com.coco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author zhangxiaoxun
 * @date 2019/1/6  15:58
 **/
@SpringBootApplication
@EnableDiscoveryClient   //将服务节点注册到eureka server上
@EnableFeignClients    //使用Feign实现rest接口调用
public class MovieApplication {

    public static void main(String[] args){
        SpringApplication.run(MovieApplication.class, args);
    }

}
