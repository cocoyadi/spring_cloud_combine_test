package com.coco.Entity;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author zhangxiaoxun
 * @date 2019/1/5  21:03
 **/
@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;
}
