package com.coco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zhangxiaoxun
 * config server的启动类
 * @date 2019/2/19  11:44
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {
    public static void main(String args[]){
        SpringApplication.run(ConfigApplication.class, args);
    }
}
