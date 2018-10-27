package com.cafebabe.phosphor.dao;


import com.cafebabe.phosphor.model.entity.UserLogin;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: UserLoginDAO
 *
 * create_date: 2018/9/30
 *
 * create_time: 08:34
 *
 * description: 用户登录dao
 **/

public interface UserLoginDAO extends MyBatisBaseDao<UserLogin, Integer> {

    /**
     * 验证用户是否注册，验证用户的用户名和密码是否匹配
     * @param userLoginPhone 前台传来用户的手机号
     * @return 用户登录
     */
    UserLogin getUserLoginDao(@Param("userLoginPhone") String userLoginPhone);

    /**
     * 更改用户的登录密码
     * @param userLogin 用户登录类
     * @return  得到密码是否成功
     */
    boolean   updateParentPasswordDao(UserLogin userLogin);

    /**
     * 添加用户登录状态
     * @param userLogin  用户登录类
     * @return 插入用户是否成功
     */
    boolean   insertUserLogin(UserLogin userLogin);
}