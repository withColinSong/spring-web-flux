package com.domain.user.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;

@Slf4j
@Component
@WebFilter(urlPatterns = "/*")
public class HeaderFilter implements Filter {

    private final String SECRET_KEY = "SECRET_KEY";
    private final String SECRET_VALUE = "01ASFDSA";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String header = httpServletRequest.getHeader(SECRET_KEY);

        if(header == null || !header.equals(SECRET_VALUE)) {
            throw new AuthenticationException("인증 실패");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}