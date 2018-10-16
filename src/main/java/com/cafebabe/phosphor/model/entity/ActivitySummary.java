package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * activity_summary
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySummary implements Serializable {
    /**
     * 活动总结ID
     */
    private Integer activitySummaryId;

    /**
     * 活动ID
     */
    private Integer activityId;

    /**
     * 活动总结内容
     */
    private String activitySummaryContent;

    /**
     * 活动总结发布时间
     */
    private Date activitySummaryTime;

    /**
     * 删除时使用

     */
    private Integer activitySummaryStatus;

    /**
     * 冗余字段
     */
    private String activitySummarySf;

    private static final long serialVersionUID = 1L;
}