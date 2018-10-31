package com.cafebabe.phosphor.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: TeacherUi
 * <p>
 * create_date: 2018/10/18
 * <p>
 * create_time: 14:31
 * <p>
 * description:教师信息跳转界面
 **/
@Controller
@CrossOrigin
@RequestMapping("/teacherUi")
public class TeacherUi {

    /**
     * 跳转到教师列表页
     *
     * @param httpServletRequest  httpRequest
     * @param httpServletResponse httpResponse
     * @throws ServletException Servlet异常
     * @throws IOException      IO异常
     */
    @RequestMapping("getTeacherList")
    public void teacher(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/teacher/teacher.html").forward(httpServletRequest, httpServletResponse);
    }

    /**
     * 根据教师ID跳转到指定教师详情页
     *
     * @param teacherId           教师ID
     * @param httpServletRequest  httpRequest
     * @param httpServletResponse httpResponse
     * @throws ServletException Servlet异常
     * @throws IOException      IO异常
     */
    @RequestMapping("getTeacherInformation/{teacherId}")
    public void teacherInformation(@PathVariable Integer teacherId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.addCookie(new Cookie("teacherId", teacherId.toString()));
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/teacher/teacherInformation.html").forward(httpServletRequest, httpServletResponse);
    }
}
