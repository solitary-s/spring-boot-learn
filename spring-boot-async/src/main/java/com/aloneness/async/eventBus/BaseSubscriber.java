package com.aloneness.async.eventBus;

/**
 * 订阅者的基础类
 *
 * @author: tong
 * @create: 2020-04-05 11:26
 */
public interface BaseSubscriber<T> {
    void subscribe(T event);
}
