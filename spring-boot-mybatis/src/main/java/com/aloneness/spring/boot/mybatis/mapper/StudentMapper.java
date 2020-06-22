package com.aloneness.spring.boot.mybatis.mapper;

import com.aloneness.spring.boot.mybatis.domain.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> listStudent(Student student);

}
