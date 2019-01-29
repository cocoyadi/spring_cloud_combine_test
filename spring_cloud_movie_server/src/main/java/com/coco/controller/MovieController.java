package com.coco.controller;

import com.coco.Entity.User;
import com.coco.client.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangxiaoxun
 * @date 2019/1/6  16:07
 **/
@RestController
public class MovieController {
    private Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 根据id，获取会员信息
     * @param id
     * @return
     */
    public User findById(Long id){
        return this.userFeignClient.findById(id);
    }

    /**
     * 根据id和姓名，获取会员信息
     * @param id
     * @return
     */
    @GetMapping("/getUser")
    public User getUser(Long id, String username){
        return this.userFeignClient.getUser(id, username);
    }

    /**
     * 添加会员信息
     * !!!这里不能加requestBody
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    public User saveUser(User user){
        return this.userFeignClient.saveUser( user);
    }

    /**
     * 打印访问的节点信息
     */
    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider-user");
        //打印出目前是哪个节点
        logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }


    /**
     * 获取user微服务在eureka的实例元数据
     * @return
     */
    @GetMapping("/user-instance")
    public List<ServiceInstance> getServiceInstanceInfo(){
        return this.discoveryClient.getInstances("provider-user");
    }



}
