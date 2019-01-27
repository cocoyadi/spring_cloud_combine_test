package com.coco.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangxiaoxun
 * @desc 配置化RestTemplate,交由spring管理
 * @date 2019/1/6  16:02
 **/
@Configuration
public class RestTemplateConfiguration {


    //疑问点：这里可以创建单例对象进项管理吗？单例对象在高并发环境中会有怎么样的影响？
    @Bean
    @LoadBalanced   //实现客户端负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
