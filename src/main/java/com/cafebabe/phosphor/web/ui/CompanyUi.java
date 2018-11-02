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
 * @author thethingyk@gmail.com
 *
 * class_name: CompanyUi
 *
 * create_date: 2018/10/7
 *
 * create_time: 10:25
 *
 * description:
 **/
@Controller
@CrossOrigin
@RequestMapping("/companyUi")
public class CompanyUi {

    @RequestMapping("companyUi/{companyId}")
    public void companyUi(@PathVariable Integer companyId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getSession().setAttribute("companyId",companyId);
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/company/company.html")
                .forward(httpServletRequest,httpServletResponse);
    }
}
