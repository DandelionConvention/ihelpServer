package com.services.core.config.filter;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 请求参数拦截
 */
@Component
@WebFilter(urlPatterns = {
        "/*"
}, filterName = "snakeCaseQueryStringFilter")
public class SnakeCaseQueryStringConverterFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException
    {
        filterChain.doFilter(new SnakeCaseQueryStringRequestWrapper(
                (HttpServletRequest) servletRequest), servletResponse);
    }
}