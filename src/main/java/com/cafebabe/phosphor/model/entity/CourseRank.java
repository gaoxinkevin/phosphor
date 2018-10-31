package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;

/**
 * course_rank
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CourseRank implements Serializable {
    /**
     * 课程评价ID
     */
    private Integer courseRankId;

    /**
     * 课程ID
     */
    private Integer courseId;

    /**
     * 课程等级
     */
    private Long courseLevel;

    private Integer courseCount;

    /**
     * 冗余字段
     */
    private String courseRankSf;



}