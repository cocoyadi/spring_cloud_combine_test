package com.coco.Dao;

import com.coco.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhangxiaoxun
 * @date 2019/1/5  21:08
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdAndUsername(Long id,String username);
}
