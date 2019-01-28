package com.coco.configuration;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import feign.*;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * Created by yadi_coco on 2019/1/28.
 * 在Edgware版本中，feign支持自定义配置，可以使用属性配置的方式实现
 * 在feignConfiguration中添加hystiix的参数配置，当然在更高版本中已经支持配置文件的方式进行配置了
 */
@Configuration
@ConditionalOnClass({ HystrixCommand.class, HystrixFeign.class })  //前提是上下文环境中需要包含这两个类
public class FeignConfiguration {
    public static int connectTimeOutMillis = 5000;//hystrix超时时间
    public static int readTimeOutMillis = 5000; //hystrix判断失败的时间间隔

    /**
     * 配置feign日志级别
     * @return
     */
    @Bean
    public Logger.Level feginLoggerLevel(){
        return Logger.Level.FULL;
    }


    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

    /**
     *   自定义重试次数
     */
    @Bean
    public Retryer feignRetryer(){
        Retryer retryer = new Retryer.Default(100, 1000, 4);
        return retryer;
    }

    //设置hystirx的参数
    @Bean
    public Feign.Builder feignHystrixBuilder() {
        return HystrixFeign.builder().setterFactory(new SetterFactory() {
            @Override
            public HystrixCommand.Setter create(Target<?> target, Method method) {
                return HystrixCommand.Setter
                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey(FeignClient.class.getSimpleName()))// 控制 FeignClient 下,所有方法的Hystrix Configuration
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(connectTimeOutMillis) // 超时配置
                        );
            }
        });

    }

}
