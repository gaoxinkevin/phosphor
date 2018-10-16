package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;

/**
 * teacher_course
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCourse implements Serializable {
    /**
     * 私人订制ID
     */
    private Integer teacherCourseId;

    /**
     * 私人教师ID
     */
    private Integer teacherId;

    /**
     * 课程ID
     */
    private Integer courseId;

    /**
     * 冗余字段
     */
    private String teacherCourseSf;

    private static final long serialVersionUID = 1L;

}