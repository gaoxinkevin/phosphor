package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * company
 * @author 
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Company implements Serializable {
    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司注册号
     */
    private String companyRegistrationId;

    /**
     * 公司地址
     */
    private String companyAddress;

    /**
     * 公司简介
     */
    private String companyDesc;

    /**
     * 公司入驻时间
     */
    private Date companyCreateTime;

    /**
     * 告诉电话
     */
    private String companyPhone;

    /**
     * 备用电话
     */
    private String companySparePhone;

    /**
     * 存储外链
     */
    private String companyPhoto;

    /**
     * 冗余字段
     */
    private String companySf;

    private static final long serialVersionUID = 1L;

}