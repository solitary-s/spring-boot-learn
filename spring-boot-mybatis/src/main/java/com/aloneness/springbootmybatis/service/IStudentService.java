package com.aloneness.springbootmybatis.service;

import com.aloneness.springbootmybatis.domain.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> listStudent(Student student);

}
