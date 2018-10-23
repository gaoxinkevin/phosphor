package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;

/**
 * group_course
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class GroupCourse implements Serializable {
    /**
     * 套餐课程表ID
     */
    private Integer groupCourseId;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 套餐ID
     */
    private Integer groupId;

    /**
     * 订单课程的状态
     */
    private String groupCourseSf;

}