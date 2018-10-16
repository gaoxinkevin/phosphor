package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.Company;

import java.util.List;

/**
 * CompanyDAO继承基类
 */
public interface CompanyDAO extends MyBatisBaseDao<Company, Integer> {
    /**
     * 获取所有的的公司信息
     * @return company的列表
     */
    List<Company> getCompanyListAll();

    /**
     * 添加公司
     * @return 0=>false | 1=>true
     */
    Integer insertCompany(Company company);
    /**
     * 修改公司
     * @return 0=>false | 1=>true
     */
    Integer updateCompany(Company company);
    /**
     * 删除公司
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