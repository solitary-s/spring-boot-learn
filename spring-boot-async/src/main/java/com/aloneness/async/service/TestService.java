package com.aloneness.async.service;

import com.aloneness.async.domain.Student;
import com.google.common.eventbus.AsyncEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: tong
 * @create: 2020-04-05 16:01
 */
@Service
public class TestService {

    @Autowired
    private AsyncEventBus asyncEventBus;

    public void test(){
        Student student = new Student();
        student.setId(1);
        student.setName("hello");
        asyncEventBus.post(student);
    }
}
