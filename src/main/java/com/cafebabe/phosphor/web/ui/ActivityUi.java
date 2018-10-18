package com.cafebabe.phosphor.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:    活动界面跳转封装
 * @Author:         Ningtao Liu
 * @CreateDate:     2018/10/17 20:55
 * @Version:        1.0
 */

@CrossOrigin
@Controller
@RequestMapping("/activityUi")
public class ActivityUi {

    @RequestMapping("returnActivityUi")
    public void returnActivityPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/activity/activityList.html").forward(httpServletRequest, httpServletResponse);
    }
}
