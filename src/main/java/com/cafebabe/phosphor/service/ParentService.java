package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.InsertParent;
import com.cafebabe.phosphor.model.entity.Parent;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ParentService
 *
 * create_date: 2018/9/27
 *
 * create_time: 15:23
 *
 * description: 家长 Service
 **/

public interface ParentService {

    /**
     * 获取用户所对应的用户头像
     * @param parentPhone 用户唯一识别的手机号
     * @return 用户头像
     */
    String  getParentImgUrlService(String parentPhone);

    /**
     * 通过手机号获取 用户信息
     * @param parentPhone 用户唯一识别的手机号
     * @return 用户是否存在
     */
    String getParentByParentPhoneService(String parentPhone);

    /**
     * 获得用户的所有信息
     * @param parentPhone 用户的所有信息
     * @return 用户类
     */
    Parent getAllInfoAboutParentService(String parentPhone);

    /**
     * 用户更新service
     * @param parent 更新后的用户信息
     */
    void updateByParentPhoneService(Parent parent);

    /**
     * 插入用户
     * @param insertParent 要插入的用户的信息
     * @return 插入用户是否成功
     */
    boolean insertIntoParent(InsertParent insertParent);

    /**
     * 更改用户信息是否成功
     * @param parentPhoto 用户头像信息
     * @param parentPhone 用户手机号
     */
    void updateParentImg(String parentPhoto, String parentPhone);
}
