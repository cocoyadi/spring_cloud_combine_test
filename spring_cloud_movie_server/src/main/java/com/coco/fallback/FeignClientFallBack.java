package com.coco.fallback;

import com.coco.Entity.User;
import com.coco.client.UserFeignClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by yadi_coco on 2019/1/29.
 * 添加feign客户端的回退方法
 * 需要实现feign中的方法
 */
@Component
public class FeignClientFallBack implements UserFeignClient {

    /**
     * 当调用feign失败时，执行回退方法
     * @param id
     * @return
     */
    @Override
    public User findById(@PathVariable("id") Long id) {
        User user = new User();
        user.setName("默认用户");
        user.setId(-1L);
        user.setAge(-1);
        return user;
    }

    @Override
    public User getUser(@RequestParam("id") Long id, @RequestParam("username") String username) {
        return null;
    }

    @Override
    public User saveUser(@RequestBody User user) {
        return null;
    }
}
