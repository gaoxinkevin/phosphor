package com.cafebabe.phosphor.model.dto;

import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import java.util.Date;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ChildrenInfoDto
 *
 * create_date: 2018/10/22
 *
 * create_time: 11:07
 *
 * description: 孩子信息封装
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ChildrenInfoDto implements Serializable {

    private Integer childId;

    private String  childName;

    private Integer childGender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date childBirthday;

    private String  gradeScore;

    private String  courseName;

    private String  childSf;
}
