package com.aloneness.spring.boot.mybatis.service.impl;

import com.aloneness.spring.boot.mybatis.domain.Student;
import com.aloneness.spring.boot.mybatis.mapper.StudentMapper;
import com.aloneness.spring.boot.mybatis.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> listStudent(Student student) {
        return studentMapper.listStudent(student);
    }
}
