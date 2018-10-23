package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ParentDAO;
import com.cafebabe.phosphor.dao.UserLoginDAO;
import com.cafebabe.phosphor.model.dto.InsertParent;
import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.model.entity.UserLogin;
import com.cafebabe.phosphor.service.InsertParentService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: InsertParentServiceImpl
 *
 * create_date: 2018/10/12
 *
 * create_time: 15:19
 *
 * description: dto 添加用户
 **/


@Service
public class InsertParentServiceImpl implements InsertParentService {


    private final ParentDAO parentDAO;

    private final UserLoginDAO userLoginDAO;

    @Autowired
    public InsertParentServiceImpl(ParentDAO parentDAO, UserLoginDAO userLoginDAO) {
        this.parentDAO = parentDAO;
        this.userLoginDAO = userLoginDAO;
    }

}
