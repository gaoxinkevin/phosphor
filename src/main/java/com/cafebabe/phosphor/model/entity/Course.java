package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * course
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    /**
     * 课程ID
     */
    private Integer courseId;

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
     * 课程状态
     */
    private Integer courseStatus;

    /**
     * 上课时间
     */
    private String courseTime;

    /**
     * 是否可以打折
     */
    private Integer courseDiscount;

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 冗余字段
     */
    private String courseSf;


}