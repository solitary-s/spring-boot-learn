package com.aloneness.springbootmybatis.mapper;

import com.aloneness.springbootmybatis.domain.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> listStudent(Student student);

}
