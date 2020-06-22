package com.aloneness.spring.boot.mybatis.service;

import com.aloneness.spring.boot.mybatis.domain.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> listStudent(Student student);

}
