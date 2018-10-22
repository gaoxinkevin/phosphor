package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.GroupDAO;
import com.cafebabe.phosphor.dao.OrderDAO;
import com.cafebabe.phosphor.model.entity.Order;
import com.cafebabe.phosphor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    private final int isTrue= 1;
    private final int isFalse= 0;

    @Autowired
    private final OrderDAO orderDAO;
    private final GroupDAO groupDAO;

    public OrderServiceImpl(OrderDAO orderDAO,GroupDAO groupDAO) {
        this.orderDAO=orderDAO;
        this.groupDAO=groupDAO;
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
    public Order getOrderById(Integer id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    public List<Order> getOrderListAll() {
        return orderDAO.getOrderListAll();
    }

    @Override
    public List<Order> getOrderList(Integer id) {
        return orderDAO.getOrderList(id);
    }

    @Override
    public List<Order> getOrderListByChildId(Integer id) {
        return orderDAO.getOrderListByChildId(id);
    }

    @Override
    public List<Order> getCourseOrderList(Integer parentId, Integer courseId) {
        return orderDAO.getCourseOrderList(parentId, courseId);
    }

    @Override
    public List<Order> getGroupOrderList(Integer parentId, Integer groupId) {
        return orderDAO.getGroupOrderList(parentId, groupId);
    }

    @Override
    public List<Order> getActivityOrderList(Integer parentId, Integer activityId) {
        return orderDAO.getActivityOrderList(parentId, activityId);
    }

}
