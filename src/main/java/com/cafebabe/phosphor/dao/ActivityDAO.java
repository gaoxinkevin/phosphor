package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.Activity;

import java.util.List;

/**
 * ActivityDAO继承基类
 */
public interface ActivityDAO extends MyBatisBaseDao<Activity, Integer> {
    /**
     * 获取所有活动
     * @param
     * @return      Activity List
     * @date        2018/10/17 18:50
    */
    List<Activity> getActivityAll();
    /**
     * 根据ID获取单个活动
     * @param   id
     * @return      Activity
     * @date        2018/10/17 18:51
    */
    Activity getActivityByID(Integer id);

    /**
     * 添加一个活动
     * @param   activity
     * @return 0：添加成功 1：添加失败
     * @date        2018/10/17 18:55
    */
    Integer insertActivity(Activity activity);
    /**
     * 根据id删除Activity
     * @param   id
     * @return  0：删除成功  1：删除失败
     * @date        2018/10/17 18:53
    */
    Integer deleteActivityByID(Integer id);
}