package com.aloneness.springbootmybatis;

import com.aloneness.springbootmybatis.domain.Student;
import com.aloneness.springbootmybatis.service.IStudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.aloneness.springbootmybatis.mapper")
public class SpringBootMybatisApplication implements CommandLineRunner {

    @Autowired
    private IStudentService studentService;


    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PageHelper.startPage(1, 2);
        List<Student> list = studentService.listStudent(new Student());
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
//        System.out.println(studentService.listStudent(new Student()));
    }
}
