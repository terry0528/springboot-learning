package com.laomaodiaoyu.study.sbinterceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

/**
 * 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //访问的IP
        String ipAddress = request.getRemoteAddr();
        //统计访问次数
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        count= Objects.isNull(count)?1:++count;
        session.setAttribute("count",count);
        System.out.println(ipAddress+"   count："+count);

        //放行
        return true;
    }
}
