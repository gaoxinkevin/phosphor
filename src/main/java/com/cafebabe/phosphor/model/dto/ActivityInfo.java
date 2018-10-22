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

    private Integer activityId;
    private Integer teacherId;
    private String teacherName;
    private Integer companyId;
    private String companyName;
    private String activityTitle;
    private String activityDesc;
    private Date activityStartTime;
    private Date activityEndTime;
    private String activityAddress;
    private Integer activityState;
    private Date activityApplyStartTime;
    private Date activityApplyEndTime;
    private String activityContent;
    private BigDecimal activityPrice;


}
