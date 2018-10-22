package com.cafebabe.phosphor.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: CourseInfo
 *
 * create_date: 2018/10/17
 *
 * create_time: 18:56
 *
 * description: 所有与课程相关的信息
 **/

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CourseInfo implements Serializable {
    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 课程地址
     */
    private String courseAddress;

    /**
     * 课程价格
     */
    private Long coursePrice;

    /**
     * 课程内容
     */
    private String courseContent;

    /**
     * 课程上线时间
     */
    private Date courseCreateTime;

    /**
     * 课程简介
     */
    private String courseDesc;


    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 教师名
     */
    private String teacherName;

    /**
     * 开课日期
     */

    private Date courseStartDay;

    /**
     * 上课时间
     */

    @JSONField(format ="HH:mm:ss")
    private Time courseStartTime;

    /**
     * 下课时间
     */
    @JSONField(format ="HH:mm:ss")
    private Time courseEndTime;

    /**
     * 课程持续时间（周数）
     */
    private Integer courseContinuedTime;

    /**
     * 上课时段状态
     * 0：周六 1：周天 2：寒暑假
     */
    private Integer courseTimeStatus;

}
