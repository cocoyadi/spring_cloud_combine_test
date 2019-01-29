package com.coco.fallback;

import com.coco.Entity.User;
import com.coco.client.UserFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * Created by yadi_coco on 2019/1/29.
 * 使用FeignClientFallBackFactory添加feign客户端的回退方法，方便输出错误日志
 * 在其中重写feignClient的回退方法
 */
@Component
@Slf4j
public class FeignClientFallBackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            /**
             * 当调用feign失败时，执行回退方法
             * @param id
             * @return
             */
            @Override
            public User findById(@PathVariable("id") Long id) {
                //输出回调失败的错误日志
                log.info("findById fallback cause:" , throwable);
                User user = new User();
                user.setName("默认用户");
                //可以使不同的异常返回不同的回退方法
                if(throwable instanceof IOException){
                    user.setId(-1L);
                }else{
                    user.setId(-2L);
                }
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

        };
    }


}
