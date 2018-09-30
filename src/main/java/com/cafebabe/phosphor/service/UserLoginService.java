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
     *
     * @author supersuntangao@gmail.com
     *
     * class_name: UserLoginService
     *
     * create_date: 2018/9/30
     *
     * create_time: 08:48
     *
     * description: 验证用户登录
     **/

    String getUserLoginService(String userLoginPhone,String userPassword);
}
