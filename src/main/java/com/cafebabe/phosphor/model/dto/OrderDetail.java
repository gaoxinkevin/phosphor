package com.cafebabe.phosphor.model.dto;

import com.cafebabe.phosphor.util.OrderType;
import lombok.*;

import java.math.BigDecimal;

/**
 *
 * @author thethingyk@gmail.com
 * 
 * class_name: OrderDetail
 * 
 * create_date: 18-10-17
 *
 * create_time: 下午7:37
 *
 * description:订单详情
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    /**
     * 单个商品的id
     */
    private Integer id;
    /**
     * 商品的主页面
     */
    private String path;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品简介
     */
    private String desc ;
    /**
     * 商品的展示照片路径
     */
    private String photo;
    /**
     * 商品的状态
     */
    private Integer state;
    /**
     * 商品的价格
     */
    private BigDecimal price ;

    /**
     * 商品类型：
     */
    private OrderType type;
}
