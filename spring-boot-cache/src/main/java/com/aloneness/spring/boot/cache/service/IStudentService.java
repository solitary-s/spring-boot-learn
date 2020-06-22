package com.aloneness.spring.boot.cache.service;


import com.aloneness.spring.boot.cache.domain.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> listStudent(Student student);

}
