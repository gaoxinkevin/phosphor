package com.cafebabe.phosphor.model.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: MobileAndRandomCode
 *
 * create_date: 2018/10/11
 *
 * create_time: 01:28
 *
 * description: 用于验证码发送的封装
 **/

public class MobileAndRandomCode implements Serializable {

    private String mobile;

    private Integer randomCode;

    private static final long serialVersionUID = 1L;
}
