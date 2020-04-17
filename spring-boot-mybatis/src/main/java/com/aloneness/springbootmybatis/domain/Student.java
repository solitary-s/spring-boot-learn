package com.aloneness.springbootmybatis.domain;

import com.github.pagehelper.Page;
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
