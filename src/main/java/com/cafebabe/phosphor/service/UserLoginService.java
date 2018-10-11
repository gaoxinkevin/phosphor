package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.entity.UserLogin;
import com.cafebabe.phosphor.util.JsonResponse;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: UserLoginService
 *
 * create_date: 2018/9/30
 *
 * create_time: 08:46
 *
 * description: 用户登录
 **/

public interface UserLoginService {

    /**
     * 判断用户的密码与用户名吻合可以登录
     * @param userLoginPhone
     * @param userPassword
     * @return
     */
    String getUserLoginService(String userLoginPhone,String userPassword);

    /**
     * 更改用户密码
     * @param userLogin
     * @return
     */
    boolean updateUserLoginPasswordService(UserLogin userLogin);
}
