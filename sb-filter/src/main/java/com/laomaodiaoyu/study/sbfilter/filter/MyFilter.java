package com.laomaodiaoyu.study.sbfilter.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

/**
 * 自定义过滤器，实现统计IP访问次数
 */
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //访问的IP
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ipAddress = request.getRemoteAddr();
        //统计访问次数
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        count= Objects.isNull(count)?1:++count;
        session.setAttribute("count",count);
        System.out.println(ipAddress+"   count："+count);
        //放行
        filterChain.doFilter(servletRequest,servletResponse);

    }




}
