package com.aloneness.spring.boot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @EnableCaching 开启缓存
 *
 * @author aloneness
 * @date 2020/6/22
 */
@SpringBootApplication
@EnableCaching
@MapperScan("com.aloneness.spring.boot.cache.mapper")
public class SpringBootCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }
}
