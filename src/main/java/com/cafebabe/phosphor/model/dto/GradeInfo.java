package com.cafebabe.phosphor.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class GradeInfo {
    /**
     * 孩子ID
     */
    private Integer childId;

    /**
     * 家长
     */
    private Integer parentId;

    /**
     * 孩子姓名
     */
    private String childName;

    /**
     * 课程ID
     */
    private Integer courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 教师名
     */
    private String teacherName;

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
     * 课程状态
     */
    private Integer courseStatus;
}
