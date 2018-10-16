package com.cafebabe.phosphor.model.dto;


import lombok.*;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: InsertParent
 *
 * create_date: 2018/10/12
 *
 * create_time: 15:24
 *
 * description: dto 用于插入用户
 **/


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class InsertParent {

    private String insertParentPhone;

    private String insertParentName;

    private String insetParentPassword;
}
