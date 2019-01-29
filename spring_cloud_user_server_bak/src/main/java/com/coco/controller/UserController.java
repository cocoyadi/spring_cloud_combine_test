package com.coco.controller;

import com.coco.Dao.UserRepository;
import com.coco.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author zhangxiaoxun
 * @date 2019/1/5  21:10
 **/
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 根据用户id获取用户实例
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return this.userRepository.findById(id);
    }

    /**
     * 根据用户id和姓名获取用户实例
     * @param id
     * @return
     */
    @GetMapping("/getUser")
    public User getUser(@RequestParam("id") Long id, @RequestParam("username") String username){
        User user = userRepository.findByIdAndUsername(id,username);
        return user;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
