package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.Company;

import java.util.List;

/**
 *
 * @author thethingyk@gmail.com
 * 
 * class_name: CompanyDAO
 * 
 * create_date: 18-11-3
 *
 * create_time: 上午11:19
 *
 * description: 公司相关信息实体类
 **/
public interface CompanyDAO extends MyBatisBaseDao<Company, Integer> {
    /**
     * 获取所有的的公司信息
     * @return company的列表
     */
    List<Company> getCompanyListAll();

    /**
     * 添加公司
     * @param company 公司实体类
     * @return 0=>false | 1=>true
     */
    Integer insertCompany(Company company);
    /**
     * 修改公司
     * @param company 公司实体类
     * @return 0=>false | 1=>true
     */
    Integer updateCompany(Company company);
    /**
     * 删除公司
     * @param id 公司编号
     * @return 0=>false | 1=>true
     */
    Integer removeCompany(Integer id);

    /**
     * 根据公司的id查询公司信息
     * @param id 公司id
     * @return 公司信息
     */
    Company getCompanyById(Integer id);

    /**
     * 根据公司的名字模糊查询公司信息
     * @param name 公司的模糊名称
     * @return 公司列表
     */
    List<Company> getCompanyListByName(String name);

}