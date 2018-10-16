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
 * @author thethingyk@gmail.com
 *
 * class_name: GroupUi
 *
 * create_date: 2018/10/9
 *
 * create_time: 19:32
 *
 * description:
 **/
@Controller
@CrossOrigin
@RequestMapping("/GroupUi")
public class GroupUi {

    @RequestMapping("GroupListUi")
    public void GroupList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws IOException,ServletException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/Group/GroupList.html").forward(httpServletRequest,httpServletResponse);
    }

    @RequestMapping("GroupUi")
    public void Group(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws IOException,ServletException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/Group/Group.html").forward(httpServletRequest,httpServletResponse);
    }

    @RequestMapping("GroupDiyUi")
    public void GroupDiy(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws IOException,ServletException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/Group/GroupDiy.html").forward(httpServletRequest,httpServletResponse);
    }


}
