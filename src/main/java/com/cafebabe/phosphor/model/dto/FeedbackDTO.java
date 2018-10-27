package com.cafebabe.phosphor.model.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: FeedbackDTO
 * <p>
 * create_date: 2018/10/22
 * <p>
 * create_time: 20:43
 * <p>
 * description: 教师评价封装
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO implements Serializable {

    /**
     * 评价ID
     */
    private Integer feedbackId;

    /**
     * 私人教师ID
     */
    private Integer teacherId;

    /**
     * 家长ID
     */
    private Integer parentId;

    /**
     * 评价内容
     */
    private String feedbackContent;

    /**
     * 评价状态
     */
    private Integer feedbackStatus;

    /**
     * 冗余字段
     */
    private String feedbackSf;

    /**
     * 家长姓名
     */
    private String parentName;

    /**
     * 家长头像
     */
    private String parentPhoto;
    /**
     * 家长电话
     */
    private String parentPhone;


}
