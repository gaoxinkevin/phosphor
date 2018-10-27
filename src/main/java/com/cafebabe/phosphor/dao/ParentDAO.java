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
     * @param parentMail 用户邮箱
     * @return 受影响的行数
     */
    Integer insertParentDao(@Param("parentMail") String parentMail);

    /**
     * 获得用户所对应的头像的外链
     * @param parentPhone 用户的手机号
     * @return 用户的头像
     */
    String  getParentImgUrlDao(@Param("parentPhone") String parentPhone);

    /**
     * 判断用户输入的手机号用户是否存在
     * @param parentPhone 用户的手机号
     * @return  用户
     */
    Parent  getParentByParentPhoneDao(@Param("parentPhone") String parentPhone);

    /**
     * 用户插入到数据库中
     * @param parent 用户的总体信息
     * @return 插入是否成功
     */
    boolean insertParentDao(Parent parent);

    /**
     * 查询全部用户的全部信息
     * @param parentPhone 用户的手机号
     * @return 用户的全部信息
     */
    Parent getAllInfoAboutParentDao(@Param("parentPhone") String parentPhone);

    /**
     * 更新用户信息
     * @param parent 更新过的用户信息
     * @return 受影响的行数
     */
    Integer updateByParentPhoneDao(Parent parent);

    /**
     * 根据用户手机号修改用户头像
     * @param parentPhoto 用户头像  前台获取
     * @param parentPhone 用户手机号 根据session获取
     * @return 更改成功还是失败
     */
    boolean updateParentImg(@Param("parentPhoto")String parentPhoto,@Param("parentPhone") String parentPhone);

    /**
     * 根据用户编号获取用户姓名
     * @param parentId 用户编号
     * @return 用户姓名
     */
    String getParentNameById (Integer parentId);
}