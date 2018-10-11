package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ParentDAO;
import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.service.ParentService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ParentServiceImpl
 *
 * create_date: 2018/9/27
 *
 * create_time: 15:26
 *
 * description:
 **/

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentDAO parentDAO;

    @Autowired
    public ParentServiceImpl(ParentDAO parentDAO){
        this.parentDAO = parentDAO;
    }

    @Override
    public Integer insertParentService(String parentMail) {
        return parentDAO.insertParentDao(parentMail);
    }

    @Override
    public String getParentImgUrlService(String parentPhone) {
        return parentDAO.getParentImgUrlDao(parentPhone);
    }

    @Override
    public String getParentByParentPhoneService(String parentPhone) {
        Parent  parent = parentDAO.getParentByParentPhoneDao(parentPhone);
        if (null !=parent){
            return "true";
        }else {
            return "false";
        }
    }

}
