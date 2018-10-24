package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.OrderDAO;
import com.cafebabe.phosphor.model.dto.OrderDTO;
import com.cafebabe.phosphor.model.entity.Order;
import com.cafebabe.phosphor.service.OrderService;
import com.cafebabe.phosphor.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: OrderServiceImpl
 *
 * create_date: 18-10-20
 *
 * create_time: 下午2:53
 *
 * description:
 **/

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final OrderDetailServiceImpl orderDetailService;
    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO,OrderDetailServiceImpl orderDetailService) {
        this.orderDAO=orderDAO;
        this.orderDetailService=orderDetailService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insertOrder(Order order) {
        return orderDAO.insertOrder(order);
    }

    @Override
    public Integer updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Override
    public Integer removeOrder(Integer id) {
        return orderDAO.removeOrder(id);
    }

    @Override
    public OrderDTO getOrderById(Integer id) {
        OrderDTO cache = RedisUtil.getObj("getOrderById"+id,OrderDTO.class);
        if (cache != null){
            return cache;
        }else {
            OrderDTO orderDTO = toOrderDTO(orderDAO.getOrderById(id));
            RedisUtil.set("getOrderById"+id,orderDTO);
            return orderDTO;
        }
    }

    @Override
    public List<OrderDTO> getOrderListAll() {

        List<OrderDTO> cache = RedisUtil.getList("getOrderDTOListAll");
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getOrderListAll();
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getOrderDTOListAll",orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public List<OrderDTO> getOrderList(Integer id) {

        List<OrderDTO> cache = RedisUtil.getList("getOrderList"+id);
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getOrderList(id);
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getOrderList"+id,orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public List<OrderDTO> getOrderListByChildId(Integer id) {

        List<OrderDTO> cache = RedisUtil.getList("getOrderListByChildId"+id);
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getOrderListByChildId(id);
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getOrderListByChildId"+id,orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public List<OrderDTO> getCourseOrderList(Integer parentId) {
        List<OrderDTO> cache = RedisUtil.getList("getCourseOrderList"+parentId);
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getCourseOrderList(parentId);
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getCourseOrderList"+parentId,orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public List<OrderDTO> getGroupOrderList(Integer parentId) {
        List<OrderDTO> cache = RedisUtil.getList("getGroupOrderList"+parentId);
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getGroupOrderList(parentId);
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getGroupOrderList"+parentId,orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public List<OrderDTO> getActivityOrderList(Integer parentId) {
        List<OrderDTO> cache = RedisUtil.getList("getActivityOrderList"+parentId);
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getActivityOrderList(parentId);
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getActivityOrderList"+parentId,orderDTOList);
            return orderDTOList;
        }
    }
    private OrderDTO toOrderDTO(Order order){
        if (order == null) {
            return null;
        }else {
            OrderDTO orderDTO = new OrderDTO();
            if (order.getCourseId()!=null){
                orderDTO.setDetails(orderDetailService.getListByCourseId(order.getCourseId(),order.getOrderState()));
            } else if(order.getGroupId()!=null){
                orderDTO.setDetails(orderDetailService.getListByGroupId(order.getGroupId()));
            } else if (order.getActivityId()!=null){
                orderDTO.setDetails(orderDetailService.getListByActivityId(order.getActivityId(),order.getOrderState()));
            }
            return orderDTO;
        }
    }

}
