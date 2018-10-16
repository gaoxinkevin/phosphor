package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * course_collection
 * @author 
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CourseCollection implements Serializable {
    private Integer courseCollectionId;

    private Integer courseId;

    private Integer parentId;

    private String courseCollectionSf;

    private Integer courseCollectionStatus;

    /**
     * 课程收藏创建时间
     */
    private Date courseCollectionCreateTime;

}