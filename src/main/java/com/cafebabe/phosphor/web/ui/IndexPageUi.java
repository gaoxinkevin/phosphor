package com.cafebabe.phosphor.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
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
 * class_name: IndexPageUi
 *
 * create_date: 2018/9/29
 *
 * create_time: 10:22
 *
 * description: 跳转到index.html页面
 **/


@Controller
@CrossOrigin
@RequestMapping("/indexUi")
public class IndexPageUi {

//    @Autowired(required = false)
//    private HttpServletRequest httpServletRequest;
    @RequestMapping("returnIndexPage")
    public void returnIndexPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/index.html").forward(httpServletRequest,httpServletResponse);
    }
}
