package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.dao.OrderDAO;
import com.cafebabe.phosphor.model.dto.OrderDTO;
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
    OrderDTO getOrderById(Integer id);

    /**
     * 获取所有的订单信息
     * @return group的列表
     */
    List<OrderDTO> getOrderListAll();

    /**
     * 获取所有单个用户的order
     * @return order的列表
     */
    List<OrderDTO> getOrderList(Integer id);

    /**
     * 获取所有单个孩子的所有order
     * @return order的列表
     */
    List<OrderDTO> getOrderListByChildId(Integer id);

    /**
     * 查询单个用户的所有的课程订单
     * @param parentId 用户编号
     * @return order的列表
     */
    List<OrderDTO> getCourseOrderList( Integer parentId);

    /**
     * 查询单个用户的所有的套餐订单
     * @param parentId 用户编号
     * @return order的列表
     */
    List<OrderDTO> getGroupOrderList(Integer parentId);

    /**
     * 查询单个用户的所有的活动订单
     * @param parentId 用户编号
     * @return order的列表
     */
    List<OrderDTO> getActivityOrderList(Integer parentId);

    /**
     * 根据订单类型和详情id创建订单
     * @param type 订单类型
     * @param detailId 详情编号
     * @return 订单
     */
    OrderDTO createOrder(String type, Integer detailId);
}
