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
     * 点赞ID
     */
    private Integer teacherLikeId;

    /**
     * 点赞数量
     */
    private Integer teacherLikeCount;

    /**
     * 教师ID
     */
    private Integer teacherId;

}