package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: CourseTime
 *
 * create_date: 2018/10/19
 *
 * create_time: 13:55
 *
 * description: 课程相关时间实体
 **/

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CourseTime implements Serializable {
    /**
     * 课程时间id

     */
    private Integer courseTimeId;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 开课日期
     */
    private Date courseStartDay;

    /**
     * 上课时间
     */
    private Date courseStartTime;

    /**
     * 下课时间
     */
    private Date courseEndTime;

    /**
     * 课程持续时间（周数）
     */
    private Integer courseContinuedTime;

    /**
     * 上课状态

     */
    private Integer courseTimeStatus;

    /**
     * 冗余字段
     */
    private String courseTimeSf;

    private static final long serialVersionUID = 1L;

}