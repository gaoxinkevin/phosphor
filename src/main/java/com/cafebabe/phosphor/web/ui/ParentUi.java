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
 * class_name: ParentUi
 *
 * create_date: 2018/9/27
 *
 * create_time: 15:33
 *
 * description: 家长信息跳转界面
 **/


@Controller
@CrossOrigin
@RequestMapping("/parentUi")
public class ParentUi {

    @RequestMapping("parentRegisterUi")
    public void registerForward(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/parent/parentRegister.html").forward(httpServletRequest,httpServletResponse);
    }

    @RequestMapping("forgetPasswordUi")
    public void forgetPassword(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/login/forgetPassword.html").forward(httpServletRequest,httpServletResponse);
    }
}
