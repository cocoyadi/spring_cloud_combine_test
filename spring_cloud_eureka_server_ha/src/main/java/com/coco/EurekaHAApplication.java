package com.coco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhangxiaoxun
 * @date 2018/12/8  14:26
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaHAApplication {
    public static void main(String args[]){
        SpringApplication.run(EurekaHAApplication.class, args);
    }
}
