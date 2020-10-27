package com.aloneness.spring.boot.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello, jwt!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "hello, admin!";
    }

}
