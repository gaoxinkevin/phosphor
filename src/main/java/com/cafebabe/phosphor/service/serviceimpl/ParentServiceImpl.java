package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ParentDAO;
import com.cafebabe.phosphor.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private final ParentDAO parentDAO;

    public ParentServiceImpl(ParentDAO parentDAO) {
        this.parentDAO = parentDAO;
    }

    @Override
    public Integer insertParentService(String parentMail) {
        Integer result = parentDAO.insertParentDao(parentMail);
        return result;
    }

}
