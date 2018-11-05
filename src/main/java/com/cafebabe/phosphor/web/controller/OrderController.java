package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.OrderDTO;
import com.cafebabe.phosphor.model.entity.Order;
import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.service.serviceimpl.OrderServiceImpl;
import com.cafebabe.phosphor.service.serviceimpl.ParentServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import com.cafebabe.phosphor.util.PDFUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    private static final String ORDER_ID = "orderId";
    private static final String ORDER_VALIDATE_TYPE=  "orderValidateType";
    private static final String ORDER_VALIDATE_ID= "orderValidateId";
    private static final String CREATE_ORDER = "createOrder";

    private final OrderServiceImpl orderService;
    private final ParentServiceImpl parentService;
    private HttpServletRequest httpServletRequest;

    @Autowired
    public OrderController(HttpServletRequest httpServletRequest,OrderServiceImpl orderService, ParentServiceImpl parentService) {
        this.httpServletRequest = httpServletRequest;
        this.parentService = parentService;
        this.orderService = orderService;
    }

    @RequestMapping("order")
    @ResponseBody
    public JsonResponse getOrder(){
        if (httpServletRequest.getSession().getAttribute(ORDER_ID) == null) {
            return new JsonResponse(50000,"error","订单生成失败!");
        }else {

            Integer orderId = (Integer)httpServletRequest.getSession().getAttribute(ORDER_ID);
            OrderDTO orderDTO = orderService.getOrderById(orderId);
            if (orderDTO == null) {
                return new JsonResponse(40000,"error","订单生成失败!");
            }else {
                return new JsonResponse(20000,"success",orderDTO);
            }
        }
    }

    @RequestMapping("orderValidate")
    @ResponseBody
    public JsonResponse getOrderValidate( ){
        if (httpServletRequest.getSession().getAttribute(ORDER_VALIDATE_TYPE) == null||httpServletRequest.getSession().getAttribute(ORDER_VALIDATE_ID)==null) {
            return new JsonResponse(50000,"error","订单生成失败!");
        }else {
            String orderType =(String)httpServletRequest.getSession().getAttribute(ORDER_VALIDATE_TYPE);
            Integer detailId = (Integer)httpServletRequest.getSession().getAttribute(ORDER_VALIDATE_ID);
            OrderDTO orderDTO = orderService.createOrder(orderType,detailId);
            if (orderDTO == null) {
                return new JsonResponse(40000,"error","订单生成失败!");
            }else {
                Parent parent = parentService.getAllInfoAboutParentService((String)httpServletRequest.getSession().getAttribute("userLoginPhone"));
                orderDTO.setParentId(parent.getParentId());
                orderDTO.setParent(parent.getParentName());
                httpServletRequest.getSession().setAttribute(CREATE_ORDER,orderDTO);
                return new JsonResponse(20000,"success",orderDTO);
            }
        }
    }

    @RequestMapping("currentOrder")
    @ResponseBody
    public JsonResponse getCurrentOrder( ){
        if (httpServletRequest.getSession().getAttribute(CREATE_ORDER) == null) {
            return new JsonResponse(50000,"error","没有订单!");
        }else {
            OrderDTO orderDTO =(OrderDTO)httpServletRequest.getSession().getAttribute(CREATE_ORDER);

            return new JsonResponse(20000,"success",orderDTO);

        }
    }


    @RequestMapping("orderPay")
    @ResponseBody
    public JsonResponse getOrderPay(){
        String groupType= "group";
        String courseType = "course";
        String activityType = "activity";
        if (httpServletRequest.getSession().getAttribute(CREATE_ORDER)==null) {
            return new JsonResponse(50000,"error","订单生成失败!");
        }else {
            OrderDTO orderDTO = (OrderDTO)httpServletRequest.getSession().getAttribute(CREATE_ORDER);
            Order order =new Order();
            order.setOrderState(0);
            order.setOrderCreateTime(orderDTO.getOrderCreateTime());
            order.setOrderEndTime(new Date());
            order.setOrderNumber(orderDTO.getOrderNumber());
            order.setOrderPrice(orderDTO.getOrderPrice());
            order.setChildId(orderDTO.getChildId());
            order.setParentId(orderDTO.getParentId());
            if(orderDTO.getOrderSf().equals(groupType)){
                order.setGroupId(orderDTO.getOrderState());
            }else if(courseType.equals(orderDTO.getOrderSf())){
                order.setCourseId(orderDTO.getOrderState());
            }else if(activityType.equals(orderDTO.getOrderSf())){
                order.setActivityId(orderDTO.getOrderState());
            }
            Integer orderId =orderService.insertOrder(order);
            if (orderId>0){
                httpServletRequest.getSession().removeAttribute(CREATE_ORDER);
                return new JsonResponse(20000, "success", orderId);
            }else{
                return new JsonResponse(50000, "error", "sql插入失败!");
            }
        }

    }

    @RequestMapping("orderChild")
    @ResponseBody
    public JsonResponse setOrderChild(Integer childId){
        if (httpServletRequest.getSession().getAttribute(CREATE_ORDER) == null) {
            return new JsonResponse(50000,"error","没有订单!");
        }else {
            OrderDTO orderDTO =(OrderDTO) httpServletRequest.getSession().getAttribute(CREATE_ORDER);
            orderDTO.setChildId(childId);
            httpServletRequest.getSession().setAttribute(CREATE_ORDER,orderDTO);
            return new JsonResponse(20000,"success","选择孩子成功!");
        }


    }

    @RequestMapping("orderList")
    @ResponseBody
    public JsonResponse getOrderList(){
        String userLoginPhone = (String)httpServletRequest.getSession().getAttribute("userLoginPhone");
        Parent parent= parentService.getAllInfoAboutParentService(userLoginPhone);
        List<OrderDTO> orderDTOS = orderService.getOrderList(parent.getParentId());
        if (orderDTOS == null||orderDTOS.size()==0) {
            return new JsonResponse(40000,"error","找不到相关信息");
        }
        return new JsonResponse(20000,"success",orderDTOS);
    }

    @RequestMapping("downloadOrderPDF")
    public void downloadOrderPDF(Integer orderId, HttpServletResponse httpServletResponse) {
        PDFUtil pdfUtil = new PDFUtil();
        String htmlCode = orderService.getHtmlCode(orderId);
        String fileName = "MyOrder.pdf";
        pdfUtil.createPDF(htmlCode, fileName);
        pdfUtil.downLoad(fileName, httpServletResponse);
        pdfUtil.deletePDF(fileName);
    }

    @RequestMapping("confirmOrder")
    @ResponseBody
    public JsonResponse getConfirmOrder(Integer orderId){
        Order order = new Order();
        order.setOrderId(orderId);

        order.setOrderState(1);
        if (orderService.updateOrder(order)>0&&orderService.createCourse(orderId)>0){
            return new JsonResponse(20000,"success","");
        }else{
            return new JsonResponse(50000, "服务器添加失败","");
        }

    }
}