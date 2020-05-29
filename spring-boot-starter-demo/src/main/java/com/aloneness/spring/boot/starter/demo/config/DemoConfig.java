package com.aloneness.spring.boot.starter.demo.config;

import com.aloneness.spring.boot.starter.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableConfigurationProperties： 开启对@ConfigurationProperties注解的支持
 *
 * @ConditionalOnProperty： 控制@Configuration注解是否生效
 *
 * 在META-INF下的spring.factories指定自动装配
 */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(
        prefix = "demo",
        name = "enable",
        havingValue = "true"
)
public class DemoConfig {

    public static final Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    @Autowired
    private DemoProperties demoProperties;

    @Bean(name = "demo")
    public DemoService demoService(){
        logger.info("开启demo-starter");
        return new DemoService(demoProperties.getSayWhat(), demoProperties.getToWho());
    }
}
