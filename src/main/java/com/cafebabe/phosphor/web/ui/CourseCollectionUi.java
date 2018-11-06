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

@Controller
@CrossOrigin
@RequestMapping("/courseCollectionUi")
public class CourseCollectionUi {
    @RequestMapping("/courseCollectionUi{parentPhone}")
    public void courseCollection(@PathVariable String parentPhone,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.addCookie(new Cookie("parentPhone",parentPhone));
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/course/courseCollection.html").forward(httpServletRequest,httpServletResponse);
    }
}
