package com.cafebabe.phosphor.model.entity;

import com.cafebabe.phosphor.util.ChildJsonDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    @JsonDeserialize(using = ChildJsonDateDeserializer.class)
    private Date childBirthday;

    /**
     * 冗余字段
     */
    private String childSf;
}