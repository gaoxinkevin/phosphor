package com.cafebabe.phosphor.model.dto;

import lombok.*;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: TeacherNameAndPageNumberDTO
 *
 * create_date: 2018/11/1
 *
 * create_time: 16:19
 *
 * description: 教师名称
 **/

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TeacherNameAndPageNumberDTO {

    private String teacherName;

    private Integer pageNumber;
}
