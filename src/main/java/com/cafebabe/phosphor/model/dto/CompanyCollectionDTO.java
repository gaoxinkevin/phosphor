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
 * description:
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CompanyCollectionDTO implements Serializable {
    private Integer companyCollectionId;

    private Integer companyId;

    private Integer parentId;

    private String companyCollectionSf;

    private Integer companyCollectionStatus;

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
