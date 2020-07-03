package com.aloneness.spring.boot.mybatisplus.domain;

import lombok.Data;

/**
 * @author aloneness
 * @date 2020/7/3
 */
@Data
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;
}
