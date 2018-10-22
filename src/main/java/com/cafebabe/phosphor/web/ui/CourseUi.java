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
 * @author weijincong@outlook.com
 *
 * class_name: CourseUi
 *
 * create_date: 2018/10/17
 *
 * create_time: 15:27
 *
 * description: 课程页面跳转
 **/

@Controller
@CrossOrigin
@RequestMapping("/courseUi")
public class CourseUi {

    @RequestMapping("courseListUi")
    public void courseList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/course/courseList.html").forward(httpServletRequest,httpServletResponse);
    }


    @RequestMapping("courseInfoUi")
    public void courseInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/course/courseInfo.html").forward(httpServletRequest,httpServletResponse);
    }
}
