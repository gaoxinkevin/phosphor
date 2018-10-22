package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.entity.Activity;

import java.util.List;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ActivityDAO
 *
 * create_date: 2018/10/18
 *
 * create_time: 18:06
 *
 * description:
 **/

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
     * @description 获取Activity的总条数
     * @param
     * @return
     * @date        2018/10/19 14:07
    */
    Integer getActivityCount();

    /**
     * @description 分页获取Activity
     * @param   page 封装有分页所需的数据
     * @return
     * @date        2018/10/19 14:09
    */
    List<Activity> getActivityByPage(Page page);

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