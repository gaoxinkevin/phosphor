package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.entity.UserLogin;

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
     * @param userLoginPhone 用户手机号
     * @param userPassword 用户密码
     * @return  登录是否成功
     */
    String getUserLoginService(String userLoginPhone,String userPassword);

    /**
     * 更改用户密码
     * @param userLogin 用户登录带有的信息
     * @return 更新是否成功
     */
    boolean updateUserLoginPasswordService(UserLogin userLogin);

}
