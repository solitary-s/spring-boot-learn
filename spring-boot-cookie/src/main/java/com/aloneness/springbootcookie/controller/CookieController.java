package com.aloneness.springbootcookie.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
public class CookieController {

    @GetMapping("addCookie")
    public String addCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("username", "pluto");

        cookie.setMaxAge(24 * 60 * 60); // 过期时间1天

        response.addCookie(cookie);

        return "ok";
    }

    /**
     * 可以使用spring的@CookieValue注解获取指定的cookie
     * @param username
     * @return
     */
    @GetMapping("getCookie")
    public String getCookie(@CookieValue(value = "username", defaultValue = "tong") String username){
        return "cookie(username) value is : " + username;
    }

    /**
     * 获取所有的Cookie
     * @param request
     * @return
     */
    @GetMapping("getAllCookie")
    public String getAllCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            return Arrays.stream(cookies)
                    .map(cookie -> String.format("%s=%s", cookie.getName(), cookie.getValue())).collect(Collectors.joining(", "));
        }
        HttpSession session = request.getSession();
        session.getId();
        return "No Cookies";
    }

    @GetMapping("getSession")
    public String getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getMaxInactiveInterval()); // 过期时间单位秒，30*60 半个小时
        return session.getId();
    }
}
