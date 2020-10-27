package com.aloneness.springbootcookie.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CookieController {

    @GetMapping("addCookie")
    public String addCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("username", "pluto");
        // 过期时间1天
        cookie.setMaxAge(24 * 60 * 60);

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
    public String getSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("3568121212", "tong");
        // Session有效时间(秒) 一个小时
        session.setMaxInactiveInterval(60 * 60);
        System.out.println(session.getMaxInactiveInterval());
        Cookie cookie = new Cookie("sessionId", "3568121212");
        // 过期时间1天
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        return "ok";
    }

    @GetMapping("getUser")
    public String getUser(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Optional<Cookie> first = Arrays.stream(request.getCookies()).filter(cookie -> "sessionId".equals(cookie.getName())).findFirst();
        Object attribute = session.getAttribute(first.get().getValue());
        System.out.println(attribute);
        return "ok";
    }
}
