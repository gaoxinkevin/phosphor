package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.OrderDTO;
import com.cafebabe.phosphor.model.entity.Order;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: OrderService
 *
 * create_date: 18-11-3
 *
 * create_time: 上午10:58
 *
 * description: 订单处理服务
 **/
@Service
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
    @SuppressWarnings("unused")
    Integer updateOrder(Order order);

    /**
     * 删除订单
     * @param id 订单编号
     * @return 0=>false | 1=>true
     */
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    List<OrderDTO> getOrderListAll();

    /**
     * 获取所有单个用户的order
     * @param id 用户编号
     * @return order的列表
     */
    List<OrderDTO> getOrderList(Integer id);

    /**
     * 获取所有单个孩子的所有order
     * @param id 孩子编号
     * @return order的列表
     */
    @SuppressWarnings("unused")
    List<OrderDTO> getOrderListByChildId(Integer id);

    /**
     * 查询单个用户的所有的课程订单
     * @param parentId 用户编号
     * @return order的列表
     */
    @SuppressWarnings("unused")
    List<OrderDTO> getCourseOrderList( Integer parentId);

    /**
     * 查询单个用户的所有的套餐订单
     * @param parentId 用户编号
     * @return order的列表
     */
    @SuppressWarnings("unused")
    List<OrderDTO> getGroupOrderList(Integer parentId);

    /**
     * 查询单个用户的所有的活动订单
     * @param parentId 用户编号
     * @return order的列表
     */
    @SuppressWarnings("unused")
    List<OrderDTO> getActivityOrderList(Integer parentId);

    /**
     * 根据订单类型和详情id创建订单
     * @param type 订单类型
     * @param detailId 详情编号
     * @return 订单
     */
    OrderDTO createOrder(String type, Integer detailId);

    /**
     * 根据订单ID创建PDF文档并暂存至服务器
     * @param orderId   订单ID
     * @return  PDF文件
     */
    @SuppressWarnings("unused")
    File createOrderPdfFile(Integer orderId);

    /**
     * 删除暂存的PDF文件
     * @param file  暂存至磁盘的pdf文件
     * @return  是否删除成功 0:删除成功 1:删除失败
     */
    @SuppressWarnings("unused")
    Integer delFile(File file);

    /**
     * 获取html页面代码
     * @param orderId 订单编号
     * @return 代码
     */
    String getHtmlCode(Integer orderId);

    /**
     * 根据订单给孩子添加课程
     * @param orderId 订单编号
     * @return 0表示失败,1表示成功
     */
    @SuppressWarnings("unused")
    Integer createCourse(Integer orderId);
}
