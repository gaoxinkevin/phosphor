package com.cafebabe.phosphor.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date childBirthday;

    /**
     * 冗余字段
     */
    private String childSf;
}