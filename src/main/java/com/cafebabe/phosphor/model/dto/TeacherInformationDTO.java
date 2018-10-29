package com.cafebabe.phosphor.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: TeacherInformationDTO
 * <p>
 * create_date: 2018/10/22
 * <p>
 * create_time: 16:58
 * <p>
 * description: 教师信息封装
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TeacherInformationDTO implements Serializable {
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
     * 点赞数量
     */
    private Integer teacherLikeCount;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 冗余字段
     */
    private String teacherSf;

}
