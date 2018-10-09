package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.CompanyDAO;
import com.cafebabe.phosphor.model.entity.Company;
import com.cafebabe.phosphor.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thethingyk@gmail.com
 * <p>
 * class_name: CompanyServiceImpl
 * <p>
 * create_date: 2018/10/2
 * <p>
 * create_time: 13:30
 * <p>
 * description:公司service层实现类
 **/
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private final CompanyDAO companyDAO;

    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public List<Company> getCompanyListAll() { return companyDAO.getCompanyListAll(); }

    @Override
    public Integer insertCompany(Company company) {
        return companyDAO.insertCompany(company);
    }

    @Override
    public Integer updateCompany(Company company) {
        return companyDAO.updateCompany(company);
    }

    @Override
    public Integer removeCompany(Integer id) {
        return companyDAO.removeCompany(id);
    }

    @Override
    public Company getCompanyById(Integer id) { return companyDAO.getCompanyById(id); }

    @Override
    public List<Company> getCompanyListByName(String name) { return companyDAO.getCompanyListByName(name); }
}
