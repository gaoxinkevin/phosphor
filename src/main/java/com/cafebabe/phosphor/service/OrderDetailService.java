package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.OrderDetail;

import java.util.List;

/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: OrderDetailService
 *
 * create_date: 18-10-23
 *
 * create_time: 上午11:13
 *
 * description:
 **/
public interface OrderDetailService {
    /**
     * 获取单个课程订单
     * @param CourseId 课程id
     * @param  state 订单状态
     * @return 订单
     */
    OrderDetail getByCourseId(Integer CourseId,Integer state);

    /**
     * 获取单个活动订单
     * @param ActivityId 活动id
     * @param  state 订单状态
     * @return 订单
     */
    OrderDetail getByActivityId(Integer ActivityId,Integer state);

    /**
     * 获取课程的订单详情
     * @param CourseId 课程id
     * @param  state 订单状态
     * @return 订单详情
     */
    List<OrderDetail> getListByCourseId(Integer CourseId,Integer state);

    /**
     *  获取活动的订单详情
     * @param ActivityId 活动id
     * @param  state 订单状态
     * @return 订单详情
     */
    List<OrderDetail> getListByActivityId(Integer ActivityId,Integer state);

    /**
     * 获取套餐的订单详情
     * @param groupId 套餐id
     * @return 订单详情
     */
    List<OrderDetail> getListByGroupId(Integer groupId);
}
