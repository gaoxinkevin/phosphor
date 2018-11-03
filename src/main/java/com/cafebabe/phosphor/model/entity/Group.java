package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * group
 * @author thethingyk@gmail.com
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Group implements Serializable {
    /**
     * 套餐ID
     */
    private Integer groupId;

    /**
     * 套餐状态
     */
    private Integer groupStatus;

    /**
     * 套餐结束时间

     */
    private Date groupEndTime;

    /**
     * 套餐名称
     */
    private String groupName;

    /**
     * 套餐折扣
     */
    private BigDecimal groupDiscount;

    /**
     * 套餐简介
     */
    private String groupContent;

    /**
     * 创建时间
     */
    private Date groupCreateTime;

    /**
     * 冗余字段
     */
    private String groupSf;

    /**
     * 套餐原价
     */
    private BigDecimal groupPrice;

    /**
     * 套餐包含课程数目
     */
    private Integer groupCourseNumber;

    /**
     * 套餐图片
     */
    private String groupPhoto;

}