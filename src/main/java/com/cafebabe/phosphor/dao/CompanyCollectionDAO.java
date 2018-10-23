package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.dto.CompanyCollectionDTO;
import com.cafebabe.phosphor.model.entity.Company;
import com.cafebabe.phosphor.model.entity.CompanyCollection;
import com.cafebabe.phosphor.util.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * @author kevingx2016@gmail.com
 *
 * class_name: TeacherCourseDAO
 *
 * create_date: 2018/10/23
 *
 * create_time: 18:51
 *
 * description: 公司收藏模块
 **/
public interface CompanyCollectionDAO extends MyBatisBaseDao<CompanyCollection, Integer> {

    /**
     * 获取用户收藏的公司信息
     * @param pageModel 含有用户ID的分页信息
     * @return 收藏的公司信息
     */
    List<CompanyCollectionDTO> getCompanyCollectionList(PageModel<CompanyCollectionDTO> pageModel);

    /**
     * 根据用户ID获取该用户收藏公司数目
     * @param parentId 用户ID
     * @return 收藏公司数目
     */
    Integer getCompanyCollectionCount(Integer parentId);

    /**
     * 获得某个已删除状态的公司收藏ID
     * @param parentId 父母ID
     * @param companyId 公司ID
     * @return 公司收藏ID
     */
    Integer getCompanyCollection(@Param("parentId") Integer parentId,@Param("companyId")Integer companyId);

    /**
     * 插入收藏公司
     * @param companyCollection 收藏公司的信息
     * @return 受影响行数
     */
    Integer insertCompanyCollection(CompanyCollection companyCollection);

    /**
     * 删除某个公司的收藏
     * @param companyCollectionId 公司收藏ID
     * @return 受影响行数
     */
    Integer removeCompanyCollection(Integer companyCollectionId);

    /**
     * 恢复某个公司的收藏
     * @param companyCollectionId 公司收藏ID
     * @return 受影响行数
     */
    Integer updateCompanyCollection(Integer companyCollectionId);
}