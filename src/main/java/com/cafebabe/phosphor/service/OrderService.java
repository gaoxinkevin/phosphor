package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.dao.OrderDAO;
import com.cafebabe.phosphor.model.entity.Order;

import java.util.List;

public interface OrderService {
    /**
     * 添加订单
     * @param order 订单对象
     * @return 0=>false | 1=>true
     */
    Integer insertOrder(Order order);

    /**
     * 修改订单
     * @param order 订单对象
     * @return  0=>false | 1=>true
     */
    Integer updateOrder(Order order);

    /**
     * 删除订单
     * @param id 订单编号
     * @return 0=>false | 1=>true
     */
    Integer removeOrder(Integer id);
    /**
     * 根据订单的id查询信息
     * @param id 订单id
     * @return 订单信息
     */
    Order getOrderById(Integer id);

    /**
     * 获取所有的订单信息
     * @return group的列表
     */
    List<Order> getOrderListAll();

    /**
     * 获取所有单个用户的order
     * @return order的列表
     */
    List<Order> getOrderList(Integer id);

    /**
     * 获取所有单个孩子的所有order
     * @return order的列表
     */
    List<Order> getOrderListByChildId(Integer id);

    /**
     * 查询单个用户的所有的课程订单
     * @param parentId 用户编号
     * @param courseId 课程编号
     * @return order的列表
     */
    List<Order> getCourseOrderList( Integer parentId, Integer courseId);

    /**
     * 查询单个用户的所有的套餐订单
     * @param parentId 用户编号
     * @param groupId 套餐编号
     * @return order的列表
     */
    List<Order> getGroupOrderList(Integer parentId, Integer groupId);

    /**
     * 查询单个用户的所有的活动订单
     * @param parentId 用户编号
     * @param activityId 活动编号
     * @return order的列表
     */
    List<Order> getActivityOrderList(Integer parentId, Integer activityId);
}