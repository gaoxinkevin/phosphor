package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;

/**
 * course_type
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CourseType implements Serializable {
    private Integer courseTypeId;

    private Integer typeId;

    private Integer courseId;

    private static final long serialVersionUID = 1L;

}