package com.aloneness.springbootmybatis.service.impl;

import com.aloneness.springbootmybatis.domain.Student;
import com.aloneness.springbootmybatis.mapper.StudentMapper;
import com.aloneness.springbootmybatis.service.IStudentService;
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
