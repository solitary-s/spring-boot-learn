package com.aloneness.async.eventBus;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 实现EventBusAdapter用于自动注册subscriber
 *
 * @author: tong
 * @create: 2020-04-05 11:36
 */
@Component
public class EventBusAdapter implements ApplicationContextAware, InitializingBean {

    @Autowired
    private AsyncEventBus asyncEventBus;

    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansWithAnnotation(EventBusListener.class).forEach((name, bean) -> {
            asyncEventBus.register(bean);
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
