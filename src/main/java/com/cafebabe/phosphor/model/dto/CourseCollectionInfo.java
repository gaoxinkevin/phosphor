package com.cafebabe.phosphor.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CourseCollectionInfo {
    /**
     * 家长ID
     */
    private Integer parentId;
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
     * 课程价格
     */
    private BigDecimal coursePrice;

    /**
     * 教师名
     */
    private String teacherName;
    /**
     * 课程图片
     */
    private String courseSf;

    /**
     * 课程销量
     */
    private Integer courseCount;
    /**
     * 课程收藏创建时间
     */
    private Date courseCollectionCreateTime;

    private Integer courseCollectionId;

}
