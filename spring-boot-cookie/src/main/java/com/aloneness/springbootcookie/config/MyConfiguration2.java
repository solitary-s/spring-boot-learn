package com.aloneness.springbootcookie.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConfiguration2 {

    private static final Logger log = LoggerFactory.getLogger(MyConfiguration2.class);

    public MyConfiguration2(){
        log.info("MyConfiguration2 construct..." );
    }

    public void execute() {
        log.info("MyConfiguration2 execute...");
    }
}
