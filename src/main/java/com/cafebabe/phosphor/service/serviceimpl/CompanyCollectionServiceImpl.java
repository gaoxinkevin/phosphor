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

import java.util.Date;

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
        pageModel.setPageSize(3);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        Parent parent = parentDAO.getAllInfoAboutParentDao(pageModel.getSfString());
        pageModel.setTotalRecord(companyCollectionDAO.getCompanyCollectionCount(parent.getParentId()));
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ?
                pageModel.getTotalRecord() / pageModel.getPageSize() :
                pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setSf(parent.getParentId());
        pageModel.setModelList(companyCollectionDAO.getCompanyCollectionList(pageModel));
        return pageModel;
    }

    @Override
    public Integer insertCompanyCollection(CompanyCollection companyCollection) {
        Parent parent = parentDAO.getAllInfoAboutParentDao(companyCollection.getCompanyCollectionSf());
        companyCollection.setParentId(parent.getParentId());
        int flag = 0;
        CompanyCollection collection = companyCollectionDAO.getCompanyCollection(
                companyCollection.getParentId(), companyCollection.getCompanyId());
        if (collection == null) {
            flag = 1;
        }
        if (flag == 1) {
            companyCollection.setCompanyCollectionCreateTime(new Date());
            companyCollection.setCompanyCollectionStatus(1);
            return companyCollectionDAO.insertCompanyCollection(companyCollection);
        }
        if (collection.getCompanyCollectionStatus() == 1) {
            return -1;
        } else {
            return companyCollectionDAO.updateCompanyCollection(collection.getCompanyCollectionId());
        }
    }

    @Override
    public Integer removeCompanyCollection(Integer companyCollectionId) {
        return companyCollectionDAO.removeCompanyCollection(companyCollectionId);
    }
}
