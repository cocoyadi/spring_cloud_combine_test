package com.coco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhangxiaoxun
 * @date 2019/1/6  15:58
 **/
@SpringBootApplication //从Edgware开始，@EnableDiscoveryClient注解省略的情况下也可以使用eureka
@EnableFeignClients    //使用Feign实现rest接口调用
@EnableHystrix   //调用hystirx容错
@EnableCircuitBreaker   //配置整合hystrix监控
public class MovieApplication {

    public static void main(String[] args){
        SpringApplication.run(MovieApplication.class, args);
    }

}
