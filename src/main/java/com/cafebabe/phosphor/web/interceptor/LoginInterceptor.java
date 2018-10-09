package com.cafebabe.phosphor.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: LoginInterceptor
 *
 * create_date: 2018/10/8
 *
 * create_time: 10:57
 *
 * description: 判断是否有session 有session 可以进 没有session不可以进入
 **/

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String userLoginPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        if (userLoginPhone!=null){
            return true;
        }else {
            httpServletRequest.getRequestDispatcher("/indexUi/returnIndexPage").forward(httpServletRequest,httpServletResponse);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
