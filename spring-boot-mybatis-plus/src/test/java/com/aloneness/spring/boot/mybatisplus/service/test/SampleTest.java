package com.aloneness.spring.boot.mybatisplus.service.test;

import com.aloneness.spring.boot.mybatisplus.domain.User;
import com.aloneness.spring.boot.mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author aloneness
 * @date 2020/7/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMybatisPlus() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
