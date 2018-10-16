package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * child
 * @author 
 */

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
    private Date childBirthday;

    /**
     * 冗余字段
     */
    private String childSf;

    private static final long serialVersionUID = 1L;

}