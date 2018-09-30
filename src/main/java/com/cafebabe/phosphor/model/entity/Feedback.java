package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;

/**
 * feedback
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Feedback implements Serializable {
    /**
     * 投诉ID
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
     * 投诉内容
     */
    private String feedbackContent;

    /**
     * 投诉状态
     */
    private Integer feedbackStatus;

    /**
     * 冗余字段
     */
    private String feedbackSf;

    private static final long serialVersionUID = 1L;

}