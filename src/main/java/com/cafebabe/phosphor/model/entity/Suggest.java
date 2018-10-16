package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * suggest
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Suggest implements Serializable {
    /**
     * 评价ID
     */
    private Integer suggestId;

    /**
     * 订单编号
     */
    private Integer orderId;

    /**
     * 家长ID
     */
    private Integer parentId;

    /**
     * 评价人姓名
     */
    private String parentName;

    /**
     * 评价内容
     */
    private String suggestContent;

    /**
     * 评价状态
     */
    private Integer suggestStatus;

    /**
     * 评价人头像
     */
    private String suggestPhoto;

    /**
     * 评论创建时间
     */
    private Date suggestCreateTime;

    /**
     * 冗余字段
     */
    private String suggestSf;

    private static final long serialVersionUID = 1L;

}