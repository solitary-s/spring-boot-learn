package com.aloneness.springbootcookie.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConfiguration1 {

    private static final Logger log = LoggerFactory.getLogger(MyConfiguration1.class);

    public MyConfiguration1(){
        log.info("MyConfiguration1 construct..." );
    }

    public void execute() {
        log.info("MyConfiguration1 execute...");
    }
}
