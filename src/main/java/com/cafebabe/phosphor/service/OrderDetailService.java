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
     * @param courseId 课程id
     * @return 订单
     */
    @SuppressWarnings("unused")
    OrderDetail getByCourseId(Integer courseId);

    /**
     * 获取单个活动订单
     * @param activityId 活动id
     * @return 订单
     */
    @SuppressWarnings("unused")
    OrderDetail getByActivityId(Integer activityId);

    /**
     * 获取课程的订单详情
     * @param courseId 课程id
     * @return 订单详情
     */
    List<OrderDetail> getListByCourseId(Integer courseId);

    /**
     *  获取活动的订单详情
     * @param activityId 活动id
     * @return 订单详情
     */
    List<OrderDetail> getListByActivityId(Integer activityId);

    /**
     * 获取套餐的订单详情
     * @param groupId 套餐id
     * @return 订单详情
     */
    List<OrderDetail> getListByGroupId(Integer groupId);


}
