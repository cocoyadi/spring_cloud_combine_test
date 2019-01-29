package com.coco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by yadi_coco on 2019/1/29.
 * hystrix可视化监控器启动类
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardApplication {
    public static void main(String args[]){
        SpringApplication.run(HystrixDashBoardApplication.class, args);
    }
}
