package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.CompanyCollectionDTO;
import com.cafebabe.phosphor.model.entity.CompanyCollection;
import com.cafebabe.phosphor.util.PageModel;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: CompanyCollectionService
 * <p>
 * create_date: 2018/10/23
 * <p>
 * create_time: 19:20
 * <p>
 * description:  公司收藏 Service
 **/
public interface CompanyCollectionService {

    /**
     * 根据用户ID获取收藏公司信息
     *
     * @param pageModel 含有用户ID的分页信息
     * @return 收藏的公司信息
     */
    PageModel<CompanyCollectionDTO> getCompanyCollectionList(PageModel<CompanyCollectionDTO> pageModel);

    /**
     * 添加新的公司收藏
     *
     * @param companyCollection 公司收藏信息
     * @return 受影响行数
     */
    Integer insertCompanyCollection(CompanyCollection companyCollection);

    /**
     * 删除公司收藏
     *
     * @param companyCollectionId 公司收藏ID
     * @return 受影响行数
     */
    Integer removeCompanyCollection(Integer companyCollectionId);
}
