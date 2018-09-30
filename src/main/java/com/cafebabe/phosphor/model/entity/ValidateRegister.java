package com.cafebabe.phosphor.model.entity;

import lombok.*;
import org.intellij.lang.annotations.Identifier;

import java.util.Date;

import java.io.Serializable;


/**
 * validate_register
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor

public class ValidateRegister implements Serializable {

    /**
     * 无用的ID不需要进行处理
     */
    private Integer validateRegisterId;

    /**
     * 家长姓名
     */
    private String parentName;

    /**
     * 用户密码
     */
    private String parentPassword;

    /**
     * 用户token
     */
    private String parentToken;

    /**
     * token存在的时间
     */
    private Date parentTokenTime;

    /**
     * 用户email
     */
    private String parentEmail;

    /**
     * 用户手机号
     */
    private String parentPhone;

    private static final long serialVersionUID = 1L;

    public ValidateRegister() {
    }

    public ValidateRegister(String parentName, String parentPassword, String parentToken, Date parentTokenTime, String parentEmail, String parentPhone) {
        this.parentName = parentName;
        this.parentPassword = parentPassword;
        this.parentToken = parentToken;
        this.parentTokenTime = parentTokenTime;
        this.parentEmail = parentEmail;
        this.parentPhone = parentPhone;
    }
}