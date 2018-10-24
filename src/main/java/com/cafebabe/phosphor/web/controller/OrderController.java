package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.OrderDTO;
import com.cafebabe.phosphor.model.dto.OrderDetail;
import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.service.serviceimpl.CompanyServiceImpl;
import com.cafebabe.phosphor.service.serviceimpl.OrderServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import com.cafebabe.phosphor.util.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

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


    private final OrderServiceImpl orderService;
    @Autowired(required = false)
    private HttpServletRequest httpServletRequest;

    @Autowired
    public OrderController(OrderServiceImpl orderService) { this.orderService = orderService; }

    @RequestMapping("order")
    @ResponseBody
    public JsonResponse getOrder(Integer orderId){
        OrderDTO orderDTO = orderService.getOrderById(orderId);
        return new JsonResponse(20000,"success",orderDTO);
    }
    @RequestMapping("validateOrder")
    @ResponseBody
    public JsonResponse getValidateOrder( ){
        OrderDetail order = new OrderDetail();
        return new JsonResponse(20000,"success",order);
    }
    @RequestMapping("orderList")
    @ResponseBody
    public JsonResponse getOrderList(){
        Parent parent = (Parent)httpServletRequest.getSession().getAttribute("parent");
        parent.setParentId(10001);
        if (parent == null) {
            return new JsonResponse(50000,"success","系统炸了,好生处理");
        }
        List<OrderDTO> orderDTOList = orderService.getOrderList(parent.getParentId());
        if (orderDTOList == null) {
            return new JsonResponse(40000,"error","找不到相关信息");
        }
        return new JsonResponse(20000,"success",orderDTOList);
    }


}