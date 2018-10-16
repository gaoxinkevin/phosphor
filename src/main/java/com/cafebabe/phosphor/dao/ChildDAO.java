package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.Child;

import java.util.List;


/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ChildDAO
 *
 * create_date: 2018/9/26
 *
 * create_time: 16:22
 *
 * description: 孩子信息
 *
 * ChildDAO继承基类
 **/

public interface ChildDAO extends MyBatisBaseDao<Child, Integer> {
    /**
     * 查询全部的孩子信息
     * @return 查询全部的孩子信息
     */
    List<Child> getChildDao();
}