package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * grade
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Grade implements Serializable {
    /**
     * 成绩ID
     */
    private Integer gradeId;

    /**
     * 课程ID
     */
    private Integer courseId;

    /**
     * 孩子ID
     */
    private Integer childId;

    /**
     * 分数
     */
    private Long gradeScore;

    /**
     * 成绩描述
     */
    private String gradeDesc;

    /**
     * 建议
     */
    private String gradeSuggest;

    /**
     * 成绩发布时间
     */
    private Date gradeTime;

    /**
     * 冗余字段
     */
    private String gradeSf;



}