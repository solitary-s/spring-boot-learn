package com.aloneness.spring.boot.cache.service.impl;


import com.aloneness.spring.boot.cache.domain.Student;
import com.aloneness.spring.boot.cache.mapper.StudentMapper;
import com.aloneness.spring.boot.cache.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Cacheable(cacheNames = "studentCache", key = "#root.methodName")
    public List<Student> listStudent(Student student) {
        return studentMapper.listStudent(student);
    }
}
