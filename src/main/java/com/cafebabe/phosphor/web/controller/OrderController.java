package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.OrderDetail;
import com.cafebabe.phosphor.service.serviceimpl.CompanyServiceImpl;
import com.cafebabe.phosphor.service.serviceimpl.OrderServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import com.cafebabe.phosphor.util.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: OrderController
 *
 * create_date: 18-10-22
 *
 * create_time: 下午1:59
 *
 * description:
 **/
@Controller
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private final OrderServiceImpl orderService;
    public OrderController(OrderServiceImpl orderService) { this.orderService = orderService; }

    @RequestMapping("order")
    @ResponseBody
    public JsonResponse getCompany( ){
        OrderDetail order = new OrderDetail(1,
                "/order",
                "zhangliang",
                "malatang",
                "/mmp.jpg",
                1,
                new BigDecimal(100),
                OrderType.Group);
        System.out.println(order.getType().getTypeName());
        return new JsonResponse(20000,"success",order);
    }

}