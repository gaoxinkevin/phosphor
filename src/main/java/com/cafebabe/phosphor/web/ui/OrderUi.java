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
 * class_name: OrderUi
 *
 * create_date: 18-10-22
 *
 * create_time: 下午8:47
 *
 * description: 订单界面分发
 **/
@Controller
@CrossOrigin
@RequestMapping("/orderUi")
public class OrderUi {

    @RequestMapping("orderUi")
    public void orderUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/order.html")
                .forward(httpServletRequest,httpServletResponse);
    }

    @RequestMapping("orderListUi")
    public void orderListUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/orderList.html")
                .forward(httpServletRequest,httpServletResponse);
    }
    @RequestMapping("orderValidateUi")
    public void orderValidateUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/orderValidate.html")
                .forward(httpServletRequest,httpServletResponse);
    }
    @RequestMapping("orderGroupUi")
    public void orderGroupUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/orderValidate.html")
                .forward(httpServletRequest,httpServletResponse);
    }
    @RequestMapping("orderCourseUi")
    public void orderCourseUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/orderValidate.html")
                .forward(httpServletRequest,httpServletResponse);
    }
    @RequestMapping("orderActivityUi")
    public void orderActivityUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/orderValidate.html")
                .forward(httpServletRequest,httpServletResponse);
    }

}
