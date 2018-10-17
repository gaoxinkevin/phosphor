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
 * class_name: testUi
 *
 * create_date: 2018/10/17
 *
 * create_time: 12:21
 *
 * description:
 **/

@Controller
@CrossOrigin
@RequestMapping("/testUi")
public class testUi {
    @RequestMapping("testUpload")
    public void test(HttpServletRequest h , HttpServletResponse r) throws ServletException, IOException {
        h.getRequestDispatcher("/WEB-INF/pages/test/test.html").forward(h,r);
    }
}
