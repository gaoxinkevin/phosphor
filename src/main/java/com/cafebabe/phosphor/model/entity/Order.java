package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * order
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 订单状态
     */
    private Integer orderState;

    /**
     * 订单价格
     */
    private Long orderPrice;

    /**
     * 家长ID
     */
    private Integer parentId;

    /**
     * 孩子ID
     */
    private Integer childId;

    /**
     * 课程ID
     */
    private Integer courseId;

    /**
     * 套餐ID
     */
    private Integer groupId;

    /**
     * 活动ID
     */
    private Integer activityId;

    /**
     * 订单结束时间
     */
    private Date orderEndTime;

    /**
     * 订单创建时间
     */
    private Date orderCreateTime;

    /**
     * 冗余字段
     */
    private String orderSf;

    private static final long serialVersionUID = 1L;

}