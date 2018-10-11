package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.Parent;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ParentDAO
 *
 * create_date: 2018/9/27
 *
 * create_time: 15:21
 *
 * description: 用户模块
 **/

public interface ParentDAO extends MyBatisBaseDao<Parent, Integer> {

    /**
     * 用户插入
     * @param parentMail
     * @return
     */
    Integer insertParentDao(@Param("parentMail") String parentMail);

    /**
     * 获得用户所对应的头像的外链
     * @param parentPhone
     * @return
     */
    String  getParentImgUrlDao(@Param("parentPhone") String parentPhone);

    /**
     * 判断用户输入的手机号用户是否存在
     * @param parentPhone
     * @return
     */
    Parent  getParentByParentPhoneDao(@Param("parentPhone") String parentPhone);
}