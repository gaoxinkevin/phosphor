package com.cafebabe.phosphor.model.entity;


import com.cafebabe.phosphor.util.ChildJsonDateDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.*;

import java.io.Serializable;

import java.util.Date;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: Child
 *
 * create_date: 2018/10/25
 *
 * create_time: 09:12
 *
 * description: 孩子类
 **/


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Child implements Serializable {
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
     * 孩子性别
     */
    private Integer childGender;

    /**
     * 孩子生日
     */
    @JsonDeserialize(using = ChildJsonDateDeserializer.class)
    private Date childBirthday;

    /**
     * 冗余字段
     */
    private String childSf;
}