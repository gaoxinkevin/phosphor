package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;

import java.util.Date;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: Parent
 *
 * create_date: 2018/10/25
 *
 * create_time: 09:13
 *
 * description: 家长类
 **/


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Parent implements Serializable {
    /**
     * 家长ID
     */
    private Integer parentId;

    /**
     * 家长姓名
     */
    private String parentName;

    /**
     * 家长电话
     */
    private String parentPhone;

    /**
     * 家长地址
     */
    private String parentAddress;

    /**
     * 家长个性签名
     */
    private String parentDesc;

    /**
     * 家长头像
     */
    private String parentPhoto;

    /**
     * 家长邮箱
     */
    private String parentMail;

    /**
     * 家长备用电话
     */
    private String parentPrephone;

    /**
     * 家长注册时间
     */
    private Date parentCreateTime;

    /**
     * 冗余字段
     */
    private String parentSf;
}