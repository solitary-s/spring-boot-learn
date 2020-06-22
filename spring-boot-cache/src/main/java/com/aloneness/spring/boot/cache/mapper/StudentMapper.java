package com.aloneness.spring.boot.cache.mapper;


import com.aloneness.spring.boot.cache.domain.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> listStudent(Student student);

}
