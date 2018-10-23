package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.CompanyCollectionDAO;
import com.cafebabe.phosphor.dao.ParentDAO;
import com.cafebabe.phosphor.model.dto.CompanyCollectionDTO;
import com.cafebabe.phosphor.model.entity.CompanyCollection;
import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.service.CompanyCollectionService;
import com.cafebabe.phosphor.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: CompanyCollectionServiceImpl
 * <p>
 * create_date: 2018/10/23
 * <p>
 * create_time: 19:20
 * <p>
 * description:
 **/
@Service
public class CompanyCollectionServiceImpl implements CompanyCollectionService {

    @Autowired
    private final CompanyCollectionDAO companyCollectionDAO;
    @Autowired
    private final ParentDAO parentDAO;

    public CompanyCollectionServiceImpl(CompanyCollectionDAO companyCollectionDAO, ParentDAO parentDAO) {
        this.companyCollectionDAO = companyCollectionDAO;
        this.parentDAO = parentDAO;
    }

    @Override
    public PageModel<CompanyCollectionDTO> getCompanyCollectionList(PageModel<CompanyCollectionDTO> pageModel) {
        System.out.println(pageModel);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        Parent parent =parentDAO.getAllInfoAboutParentDao(pageModel.getSfString());
        pageModel.setTotalRecord(companyCollectionDAO.getCompanyCollectionCount(parent.getParentId()));
        pageModel.setSf(parent.getParentId());
        pageModel.setModelList(companyCollectionDAO.getCompanyCollectionList(pageModel));
        System.out.println(pageModel);
        return pageModel;
    }

    @Override
    public Integer insertCompanyCollection(CompanyCollection companyCollection) {
        return null;
    }

    @Override
    public Integer removeCompanyCollection(Integer companyCollectionId) {
        return null;
    }
}
