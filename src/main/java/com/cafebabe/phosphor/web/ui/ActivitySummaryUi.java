package com.cafebabe.phosphor.web.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@Controller
@RequestMapping("/activitySummaryUi")
public class ActivitySummaryUi {

    @RequestMapping("returnActivitySummaryUi")
    public void activitySummary(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/activitySummary/activitySummary.html").forward(httpServletRequest, httpServletResponse);
    }
}
