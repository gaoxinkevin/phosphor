package com.cafebabe.phosphor.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:    联系页界面跳转封装
 * @Author:         Ningtao Liu
 * @CreateDate:     2018/11/3 9:41
 * @Version:        1.0
 */

@CrossOrigin
@Controller
@RequestMapping("/contactUi")
public class ContactUi {

    @RequestMapping("returnContactUi")
    public void returnContactUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/contactUs/contactUs.html").forward(httpServletRequest, httpServletResponse);
    }
    @RequestMapping("returnMapUi")
    public void returnMapUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/map/map.html").forward(httpServletRequest, httpServletResponse);
    }
    @RequestMapping("alreadyLoginContactUsUi")
    public void alreadyLoginContactUsUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/contactUs/alreadyLoginContactUs.html").forward(httpServletRequest, httpServletResponse);
    }

}
