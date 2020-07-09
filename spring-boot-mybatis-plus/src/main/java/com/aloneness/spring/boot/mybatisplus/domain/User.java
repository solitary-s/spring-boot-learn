package com.aloneness.spring.boot.mybatisplus.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author aloneness
 * @date 2020/7/3
 */
@Setter
@Getter
@ToString
public class User {

    private Long id;

    private String userName;

    private Integer age;

    private String email;
}
