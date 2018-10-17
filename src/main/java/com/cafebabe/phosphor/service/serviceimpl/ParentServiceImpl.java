package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ParentDAO;
import com.cafebabe.phosphor.dao.UserLoginDAO;
import com.cafebabe.phosphor.model.dto.InsertParent;
import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.model.entity.UserLogin;
import com.cafebabe.phosphor.service.ParentService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


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
    private final UserLoginDAO userLoginDAO;

    @Autowired
    public ParentServiceImpl(ParentDAO parentDAO, UserLoginDAO userLoginDAO){
        this.parentDAO = parentDAO;
        this.userLoginDAO = userLoginDAO;
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

    @Override
    public Parent getAllInfoAboutParentService(String parentPhone) {
        return parentDAO.getAllInfoAboutParentDao(parentPhone);
    }

    @Override
    public void updateByParentPhoneService(Parent parent) {
        parentDAO.updateByParentPhoneDao(parent);
    }

    @Override
    public boolean insertIntoParent(InsertParent insertParent) {
        Parent parent = new Parent();
        UserLogin userLogin = new UserLogin();

        parent.setParentCreateTime(new Date());
        parent.setParentName(insertParent.getInsertParentName());
        parent.setParentPhone(insertParent.getInsertParentPhone());

        userLogin.setUserLoginPhone(insertParent.getInsertParentPhone());
        userLogin.setUserLoginPwd(insertParent.getInsetParentPassword());

        return parentDAO.insertParentDao(parent) && userLoginDAO.insertUserLogin(userLogin);
    }

    @Override
    public boolean updateParentImg(String parentPhoto, String parentPhone) {
        return parentDAO.updateParentImg(parentPhoto,parentPhone);
    }
}
