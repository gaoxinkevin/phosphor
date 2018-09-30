package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;

/**
 * teacher_like
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TeacherLike implements Serializable {
    /**
     * 评级ID
     */
    private Integer teacherLikeId;

    /**
     * 等级
     */
    private Integer teacherLikeCount;

    /**
     * 教师ID
     */
    private Integer teacherId;

    private static final long serialVersionUID = 1L;

}