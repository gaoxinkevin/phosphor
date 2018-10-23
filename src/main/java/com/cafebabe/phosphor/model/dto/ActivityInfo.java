package com.cafebabe.phosphor.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:    用于封装活动信息
 * @Author:         Ningtao Liu
 * @CreateDate:     2018/10/18 19:20
 * @Version:        1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ActivityInfo {

    /**
     * 活动ID
     */
    private Integer activityId;
    /**
     * 教师ID
     */
    private Integer teacherId;
    /**
     * 教师名字
     */
    private String teacherName;
    /**
     * 开设机构ID
     */
    private Integer companyId;
    /**
     * 开设机构名称
     */
    private String companyName;
    /**
     * 活动标题
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
     * 活动结束时间
     */
    private Date activityEndTime;
    /**
     * 活动地点
     */
    private String activityAddress;
    /**
     * 活动当前状态
     */
    private Integer activityState;
    /**
     * 活动报名开始时间
     */
    private Date activityApplyStartTime;
    /**
     * 活动报名结束时间
     */
    private Date activityApplyEndTime;
    /**
     * 活动内容
     */
    private String activityContent;
    /**
     * 活动价格
     */
    private BigDecimal activityPrice;


}
