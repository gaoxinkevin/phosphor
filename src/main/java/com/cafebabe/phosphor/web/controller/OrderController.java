package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.OrderDTO;
import com.cafebabe.phosphor.model.dto.OrderDetail;
import com.cafebabe.phosphor.model.entity.Order;
import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.service.serviceimpl.CompanyServiceImpl;
import com.cafebabe.phosphor.service.serviceimpl.OrderDetailServiceImpl;
import com.cafebabe.phosphor.service.serviceimpl.OrderServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import com.cafebabe.phosphor.util.OrderType;
import org.apache.commons.io.FileUtils;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
    private final String orderValidateType ="orderValidateType";
    private final String orderValidateId ="orderValidateId";


    @Autowired(required = false)
    private HttpServletRequest httpServletRequest;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("order")
    @ResponseBody
    public JsonResponse getOrder(Integer orderId){
        OrderDTO orderDTO = orderService.getOrderById(orderId);
        return new JsonResponse(20000,"success",orderDTO);
    }

    @RequestMapping("orderValidate")
    @ResponseBody
    public JsonResponse getOrderValidate( ){
        if (httpServletRequest.getSession().getAttribute(orderValidateType) == null||httpServletRequest.getSession().getAttribute(orderValidateId)==null) {
            return new JsonResponse(50000,"error","订单生成失败!");
        }else {
            String orderType =(String)httpServletRequest.getSession().getAttribute(orderValidateType);
            Integer detailId = (Integer)httpServletRequest.getSession().getAttribute(orderValidateId);
            OrderDTO orderDTO = orderService.createOrder(orderType,detailId);
            if (orderDTO == null) {
                return new JsonResponse(40000,"error","订单生成失败!");
            }else {
                httpServletRequest.getSession().setAttribute("createdOrder",orderDTO);
                return new JsonResponse(20000,"success",orderDTO);
            }
        }
    }

    @RequestMapping("orderPay")
    @ResponseBody
    public JsonResponse getOrderPay(){
        if (httpServletRequest.getSession().getAttribute("parentId") == null
                ||httpServletRequest.getSession().getAttribute("childId")==null
                ||httpServletRequest.getSession().getAttribute("createdOrder")==null) {
            return new JsonResponse(50000,"error","订单生成失败!");
        }else {
            Integer parentId = (Integer) httpServletRequest.getSession().getAttribute("parentId");
            Integer childId = (Integer) httpServletRequest.getSession().getAttribute("childId");
            OrderDTO orderDTO = (OrderDTO)httpServletRequest.getSession().getAttribute("createdOrder");
            Order order =new Order();
            order.setOrderState(1);
            order.setOrderCreateTime(orderDTO.getOrderCreateTime());
            order.setOrderEndTime(new Date());
            order.setOrderNumber(orderDTO.getOrderNumber());
            order.setOrderPrice(orderDTO.getOrderPrice());
            order.setChildId(childId);
            order.setParentId(parentId);
            if(orderDTO.getOrderState()<2){
                order.setCourseId(orderDTO.getDetails().get(0).getId());
            }else{
                order.setCourseId(orderDTO.getOrderState());
            }
            if (orderService.insertOrder(order)>0){
                return new JsonResponse(20000, "success", "success");
            }else{
                return new JsonResponse(50000, "error", "sql插入失败!");
            }

        }

    }

    @RequestMapping("orderChild")
    @ResponseBody
    public JsonResponse setOrderChild(Integer childId){
        httpServletRequest.getSession().setAttribute("childId",childId);
        return new JsonResponse(20000,"success","选择孩子成功!");
    }

    @RequestMapping("orderList")
    @ResponseBody
    public JsonResponse getOrderList(){
        Parent parent = (Parent)httpServletRequest.getSession().getAttribute("parent");

        /*if (parent == null) {
            return new JsonResponse(50000,"success","系统炸了,好生处理");
        }*/
        List<OrderDTO> orderDTOS = orderService.getOrderList(10001);
        if (orderDTOS == null||orderDTOS.size()==0) {
            return new JsonResponse(40000,"error","找不到相关信息");
        }
        return new JsonResponse(20000,"success",orderDTOS);
    }

    @RequestMapping("childInfo")
    @ResponseBody
    public JsonResponse getChildInfo(Integer childId){
        System.out.println(childId);
        return new JsonResponse(20000,"success","成功");
    }

    @RequestMapping("/downloadOrderPDF/{orderId}")
    public ResponseEntity<byte[]> downloadOrderPDF(@PathVariable Integer orderId) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        File pdfFile = orderService.createOrderPdfFile(orderId);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "order_"+orderId+".pdf");
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(pdfFile), headers, HttpStatus.CREATED);
    }
}