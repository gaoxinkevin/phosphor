package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.entity.Company;

import java.util.List;

/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: CompanyService
 *
 * create_date: 2018/9/30
 *
 * create_time: 14:52
 *
 * description: 公司Service层接口
 **/
public interface CompanyService {
    /**
     * 获取所有公司信息
     * @return 公司的相关信息的列表
     */
    List<Company> getCompanyListAll();

    /**
     * 插入公司的数据对象
     * @param company 需要插入公司对象
     * @return 0=>false | 1=>true
     */
    Integer insertCompany(Company company);

    /**
     * 修改单个公司信息
     * @param company 需要修改的公司的相关信息()
     * @return 0=>false | 1=>true
     */
    Integer updateCompany(Company company);

    /**
     * 根据公司id删除单个公司信息
     * @param id 公司id
     * @return 0=>false | 1=>true
     */
    Integer removeCompany(Integer id );

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
