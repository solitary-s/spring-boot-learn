package com.aloneness.async.service;

import com.aloneness.async.domain.Student;
import com.aloneness.async.eventBus.BaseSubscriber;
import com.aloneness.async.eventBus.EventBusListener;
import com.google.common.eventbus.Subscribe;
import org.springframework.stereotype.Service;

/**
 *
 * 订阅者
 *
 * @author: tong
 * @create: 2020-04-05 15:57
 */
@EventBusListener
@Service
public class HelloService implements BaseSubscriber<Student> {

    @Override
    @Subscribe
    public void subscribe(Student event) {
        System.out.println("订阅者1" + event);
    }

    @Subscribe
    public void subscribe1(Student event) {
        System.out.println("订阅者2" + event);
    }

    @Subscribe
    public void subscribe2(Student event) {
        System.out.println("订阅者3" + event);
    }
}
