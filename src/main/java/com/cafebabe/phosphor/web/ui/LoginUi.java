package com.cafebabe.phosphor.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: LoginUi
 *
 * create_date: 2018/9/27
 *
 * create_time: 09:28
 *
 * description: 登录页面的跳转封装
 **/

@CrossOrigin
@Controller
@RequestMapping("/loginUi")
public class LoginUi {

    @RequestMapping("loginUi")
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/login/login.html").forward(httpServletRequest,httpServletResponse);
    }

    @RequestMapping("alreadyLoginUi")
    public void alreadyLogin(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/login/AlreadyLoginIndex.html").forward(httpServletRequest,httpServletResponse);
    }
}
