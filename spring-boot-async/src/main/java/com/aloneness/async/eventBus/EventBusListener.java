package com.aloneness.async.eventBus;

import java.lang.annotation.*;

/**
 *
 * 加上这个注解，表明这个类是事件监听器
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EventBusListener {
}
