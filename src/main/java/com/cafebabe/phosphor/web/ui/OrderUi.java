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
 * @author thethingyk@gmail.com
 * <p>
 * class_name: OrderUi
 * <p>
 * create_date: 18-10-22
 * <p>
 * create_time: 下午8:47
 * <p>
 * description: 订单界面分发
 **/
@Controller
@CrossOrigin
@RequestMapping("/orderUi")
public class OrderUi {

    @RequestMapping("orderUi/{orderId}")
    public void orderUi(@PathVariable Integer orderId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getSession().setAttribute("orderId", orderId);
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/order.html")
                .forward(httpServletRequest, httpServletResponse);
    }

    @RequestMapping("orderListUi")
    public void orderListUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/orderList.html")
                .forward(httpServletRequest, httpServletResponse);
    }

    @RequestMapping("orderValidateUi")
    public void orderValidateUi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/orderValidate.html")
                .forward(httpServletRequest, httpServletResponse);
    }

    @RequestMapping("orderGroupUi/{groupId}")
    public void orderGroupUi(@PathVariable Integer groupId, HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getSession().setAttribute("orderValidateType", "group");
        httpServletRequest.getSession().setAttribute("orderValidateId", groupId);
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/orderValidate.html")
                .forward(httpServletRequest, httpServletResponse);
    }

    @RequestMapping("orderCourseUi/{courseId}")
    public void orderCourseUi(@PathVariable Integer courseId, HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getSession().setAttribute("orderValidateType", "course");
        httpServletRequest.getSession().setAttribute("orderValidateId", courseId);
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/orderValidate.html")
                .forward(httpServletRequest, httpServletResponse);
    }

    @RequestMapping("orderActivityUi/{activityId}")
    public void orderActivityUi(@PathVariable Integer activityId, HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getSession().setAttribute("orderValidateType", "activity");
        httpServletRequest.getSession().setAttribute("orderValidateId", activityId);
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/order/orderValidate.html")
                .forward(httpServletRequest, httpServletResponse);
    }

}
