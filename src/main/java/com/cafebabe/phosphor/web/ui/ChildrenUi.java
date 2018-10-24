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
 * class_name: ChildrenUi
 *
 * create_date: 2018/10/22
 *
 * create_time: 10:35
 *
 * description: 孩子信息跳转界面
 **/

@Controller
@CrossOrigin
@RequestMapping("/childrenUi")
public class ChildrenUi {

    @RequestMapping("infoUi")
    public void childrenInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/children/childrenInfo.html").forward(httpServletRequest,httpServletResponse);
    }
}
