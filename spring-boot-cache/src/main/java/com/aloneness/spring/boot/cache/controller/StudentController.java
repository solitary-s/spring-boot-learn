package com.aloneness.spring.boot.cache.controller;

import com.aloneness.spring.boot.cache.domain.Student;
import com.aloneness.spring.boot.cache.service.IStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author aloneness
 * @date 2020/6/22
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/list")
    public PageInfo<Student> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> list = studentService.listStudent(new Student());
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @GetMapping("/hi")
    public String hello() {
        return "hi";
    }
}
