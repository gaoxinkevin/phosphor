package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.UserLoginDAO;
import com.cafebabe.phosphor.model.entity.UserLogin;
import com.cafebabe.phosphor.service.UserLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: UserLoginServiceImpl
 *
 * create_date: 2018/9/30
 *
 * create_time: 08:49
 *
 * description: 验证用户名的service实现类
 **/

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final UserLoginDAO userLoginDAO;

    @Autowired
    public UserLoginServiceImpl(UserLoginDAO userLoginDAO) {
        this.userLoginDAO = userLoginDAO;
    }

    @Override
    public String getUserLoginService(String userLoginPhone,String userPassword) {
        UserLogin userLogin=userLoginDAO.getUserLoginDao(userLoginPhone);
        if (userLogin != null){
            String password=userLogin.getUserLoginPwd();
            if (userPassword.equals(password)){
                return "用户名密码正确";
            }else {
                return "用户名或密码不正确，请确认后登录";
            }
        }
        return "用户名不存在请注册后登录";

    }

    @Override
    public boolean updateUserLoginPasswordService(UserLogin userLogin) {
        return userLoginDAO.updateParentPasswordDao(userLogin);
    }
}
