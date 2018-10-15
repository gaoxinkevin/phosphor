package com.cafebabe.phosphor.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author supersuntangao@gmail.com
 * <p>
 * class_name: LoginInterceptor
 * <p>
 * create_date: 2018/10/8
 * <p>
 * create_time: 10:57
 * <p>
 * description: 判断是否有session 有session 可以进 没有session不可以进入
 **/

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String userLoginPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        System.out.println("拦截器启动");
        if (userLoginPhone != null) {
            System.out.println("拦截器放行");
            return true;
        } else {
            System.out.println("拦截器阻拦");
            httpServletRequest.getRequestDispatcher("/indexUi/returnIndexPage").forward(httpServletRequest, httpServletResponse);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
