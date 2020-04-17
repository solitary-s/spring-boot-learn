package com.aloneness.springbootcors.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * 1. 可以直接使用注解@CrossOrigin
     *
     * @return
     */
    @GetMapping("/hello")
//    @CrossOrigin(value = "*")
    public String hello(){
        return "hello";
    }

}
