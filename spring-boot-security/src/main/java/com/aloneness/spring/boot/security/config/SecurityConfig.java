package com.aloneness.spring.boot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final VerifyCodeFilter verifyCodeFilter;

    public SecurityConfig(VerifyCodeFilter verifyCodeFilter) {
        this.verifyCodeFilter = verifyCodeFilter;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        // 加密
        return new BCryptPasswordEncoder();
    }

    /**
     * 密码都是123， 在内存中添加账号密码
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("logic")
                .password("$2a$10$fOqvR4MDL/RaELWokUQMl.2HdfMg.ikMIo7tTKT8MrulzQHHcOKyq").roles("admin")
                .and()
                .withUser("solitary-s")
                .password("$2a$10$fOqvR4MDL/RaELWokUQMl.2HdfMg.ikMIo7tTKT8MrulzQHHcOKyq").roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
                .antMatchers("hello").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                // 表单登录
                .formLogin()
                // 登录页面链接
                .loginPage("/login_p")
                // 表单提交
                .loginProcessingUrl("/doLogin")
                // 参数
                .usernameParameter("uname")
                // 参数
                .passwordParameter("passwd")
                // 登录成功
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write("success");
                        out.flush();
                    }
                })
                // 登录失败
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write("fail");
                        out.flush();
                    }
                })
                // 接口放开
                .permitAll()
                .and()
                // 注销
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler(){
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        out.write("logout success");
                        out.flush();
                    }
                })
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }

    /**
     * 接口开放
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/vercode");
    }
}
