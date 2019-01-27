package com.coco.client;

import com.coco.Entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * @author zhangxiaoxun
 * 使用feign创建客户端接口
 * 在Edgware版本中，feign支持自定义配置，可以使用属性配置的方式实现：https://www.jianshu.com/p/e05b90423f91?utm_source=oschina-app
 * @date 2019/1/7  16:56
 **/
@FeignClient(name = "provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    User getUser(@RequestParam("id") Long id,@RequestParam("username") String username );

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    User saveUser(@RequestBody User user);

}
