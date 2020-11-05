package com.aloneness.spring.boot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
     * 密码都是123
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
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/code/**");
    }
}
