package com.cafebabe.phosphor.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: OrderList
 *
 * create_date: 18-10-18
 *
 * create_time: 上午11:24
 *
 * description: 订单列表
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {

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
    private BigDecimal orderPrice;

    /**
     * 家长ID
     */
    private Integer parentId;

    /**
     * 孩子ID
     */
    private Integer childId;
    /**
     * 家长名称
     */
    private String parent;

    /**
     * 孩子名称
     */
    private String child;

    /**
     * 订单详情
     */
    private List<OrderDetail> details;

    /**
     * 订单结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern ="yyyy-MM-dd HH:mm:ss")
    private Date orderEndTime;

    /**
     * 订单创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern ="yyyy-MM-dd HH:mm:ss")
    private Date orderCreateTime;

    /**
     * 冗余字段
     */
    private String orderSf;
}
