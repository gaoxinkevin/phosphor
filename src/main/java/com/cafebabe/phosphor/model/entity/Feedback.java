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


}