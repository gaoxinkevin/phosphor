package com.cafebabe.phosphor.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: CompanyCollectionDTO
 * <p>
 * create_date: 2018/10/23
 * <p>
 * create_time: 19:23
 * <p>
 * description: 公司收藏封装
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CompanyCollectionDTO implements Serializable {

    /**
     * 公司收藏ID
     */
    private Integer companyCollectionId;

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 家长ID
     */
    private Integer parentId;

    /**
     * 公司收藏状态
     */
    private Integer companyCollectionStatus;

    /**
     * 公司收藏冗余字段
     */
    private String companyCollectionSf;

    /**
     * 公司收藏时间
     */
    private Date companyCollectionCreateTime;

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

}
