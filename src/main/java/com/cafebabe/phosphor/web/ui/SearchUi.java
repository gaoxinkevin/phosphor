package com.cafebabe.phosphor.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: SearchUi
 *
 * create_date: 2018/10/29
 *
 * create_time: 14:02
 *
 * description: 搜索跳转界面
 **/

@Controller
@CrossOrigin
@RequestMapping("searchUi")
public class SearchUi{

    @RequestMapping("search")
    public void search(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/search/search.html").forward(httpServletRequest,httpServletResponse);

    }

    @RequestMapping("searchTeacher/{teacherName}")
    public void searchTeacher(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable String teacherName) throws ServletException, IOException {
        System.out.println(teacherName);
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/search/searchTeacher.html?teacherName="+teacherName).forward(httpServletRequest,httpServletResponse);
    }

    @RequestMapping("searchCourse/{courseName}")
    public void searchCourse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable String courseName) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/search/searchCourse.html?courseName="+courseName).forward(httpServletRequest,httpServletResponse);
    }

    @RequestMapping("searchActivity/{activityName}")
    public void searchActivity(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable String activityName) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/search/searchActivity.html?activityName="+activityName).forward(httpServletRequest,httpServletResponse);
    }
}
