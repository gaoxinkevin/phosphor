package com.cafebabe.phosphor.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: TeacherUi
 *
 * create_date: 2018/10/18
 *
 * create_time: 14:31
 *
 * description:
 **/
@Controller
@CrossOrigin
@RequestMapping("/teacherUi")
public class TeacherUi {

    @RequestMapping("getTeacherList")
    public void teacher(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/teacher/teacher.html").forward(httpServletRequest,httpServletResponse);

    }
}
