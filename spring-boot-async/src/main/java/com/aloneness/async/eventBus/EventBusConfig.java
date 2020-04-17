package com.aloneness.async.eventBus;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 将EventBus注入Spring IoC容器
 * 本地异步消息配置,基于guava异步消息
 *
 * @author: tong
 * @create: 2020-04-05 11:28
 */
@Configuration
public class EventBusConfig {

    @Bean
    public AsyncEventBus asyncEventBus() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(10000);
        executor.setKeepAliveSeconds(300);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return new AsyncEventBus(executor);
    }

}
