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
@RequestMapping("/groupUi")
public class GroupUi {

    @RequestMapping("groupListUi")
    public void GroupList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws IOException,ServletException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/group/groupList.html").forward(httpServletRequest,httpServletResponse);
    }

    @RequestMapping("groupUi")
    public void Group(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws IOException,ServletException {
        System.out.println("进入");
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/group/group.html").forward(httpServletRequest,httpServletResponse);
    }

    @RequestMapping("groupDiyUi")
    public void GroupDiy(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws IOException,ServletException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/group/groupDiy.html").forward(httpServletRequest,httpServletResponse);
    }


}
