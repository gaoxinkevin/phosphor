package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * activity
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Activity implements Serializable {
    /**
     * 活动ID
     */
    private Integer activityId;

    /**
     * 老师编号
     */
    private Integer teacherId;

    /**
     * 活动发起公司
     */
    private Integer companyId;

    /**
     * 活动主题
     */
    private String activityTitle;

    /**
     * 活动描述
     */
    private String activityDesc;

    /**
     * 活动开始时间
     */
    private Date activityStartTime;

    /**
     * 活动地址
     */
    private String activityAddress;

    /**
     * 活动状态
     */
    private Integer activityState;

    /**
     * 活动名称
     */
    private String companyName;

    /**
     * 冗余字段
     */
    private String activitySf;

    /**
     * 活动报名开始时间
     */
    private Date activityApplyStartTime;

    /**
     * 活动报名结束时间
     */
    private Date activityApplyEndTime;

    /**
     * 活动结束时间
     */
    private Date activityEndTime;

    private String activityContent;

    private static final long serialVersionUID = 1L;

}