package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * teacher
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    /**
     * 教师ID
     */
    private Integer teacherId;

    /**
     * 所属公司编号
     */
    private Integer companyId;

    /**
     * 教师名
     */
    private String teacherName;

    /**
     * 教师电话
     */
    private String teachePhone;

    /**
     * 教师执教时间
     */
    private Date teacherWorktime;

    /**
     * 教师个人简介
     */
    private String teacherDesc;

    /**
     * 教师头像
     */
    private String teacherPhoto;

    /**
     * 教师邮箱
     */
    private String teacherMail;

    /**
     * 教师外派状态
     */
    private Integer teacherStatus;

    /**
     * 冗余字段
     */
    private String teacherSf;

    private static final long serialVersionUID = 1L;

}