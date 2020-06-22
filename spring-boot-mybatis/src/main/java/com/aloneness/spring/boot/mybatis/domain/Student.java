package com.aloneness.spring.boot.mybatis.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Student {
    private Long id;
    private String name;
    private int age;
    private char sex;
}
