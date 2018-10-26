package com.cafebabe.phosphor.service.serviceImpl;

import com.cafebabe.phosphor.model.dto.OrderDTO;
import com.cafebabe.phosphor.service.OrderService;
import com.cafebabe.phosphor.service.serviceimpl.OrderServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class TestOrderService {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    OrderService orderService =(OrderServiceImpl) beanFactory.getBean("orderServiceImpl");
    @Test
    public void testGetOrderListAll(){
        List<OrderDTO> orderDTO = orderService.getOrderList(10001);
        System.out.println(orderDTO);
    }
    @Test
    public void testGetOrder(){
        OrderDTO orderDTO = orderService.getOrderById(10000);
        System.out.println(orderDTO);
    }

}
