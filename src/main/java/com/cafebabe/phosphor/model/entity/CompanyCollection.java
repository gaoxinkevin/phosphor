package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * company_collection
 * @author 
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CompanyCollection implements Serializable {
    private Integer companyCollectionId;

    private Integer companyId;

    private Integer parentId;

    private String companyCollectionSf;

    private Integer companyCollectionStatus;

    /**
     * 公司收藏时间
     */
    private Date companyCollectionCreateTime;

    private static final long serialVersionUID = 1L;

}
