package com.aloneness.spring.boot.security.config;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class VerifyCodeFilter extends GenericFilterBean {

    private String defaultFilterProcessUrl = "/doLogin";

    private static final String POST_METHOD = "POST";

    /**
     * 过滤器，校验验证码是否正确
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (POST_METHOD.equalsIgnoreCase(request.getMethod()) && defaultFilterProcessUrl.equals(request.getServletPath())) {
            String code = request.getParameter("code");
            String indexCode = (String) request.getSession().getAttribute("index_code");
            if (StringUtils.isEmpty(code)) {
                throw new AuthenticationServiceException("验证码不能为空");
            }
            if (!indexCode.toLowerCase().equals(code.toLowerCase())) {
                throw new AuthenticationServiceException("验证码错误");
            }
        }
        filterChain.doFilter(request, response);
    }
}
