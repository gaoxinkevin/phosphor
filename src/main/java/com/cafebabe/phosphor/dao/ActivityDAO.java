package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.entity.Activity;

import java.util.List;
import java.util.Map;

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
     * @return  活动列表
     */
    List<Activity> getActivityAll();

    /**
     * 根据ID获取活动
     * @param id    活动ID
     * @return  单个活动
     */
    Activity getActivityByID(Integer id);

    /**
     * 获取活动数量
     * @return  活动条目数
     */
    Integer getActivityCount();

    /**
     * 根据活动title获取活动数
     * @param title 活动title
     * @return 指定title下的活动记录数
     */
    Integer getActivityCountWithCondition(String title);

    /**
     * 根据公司ID获取活动列表
     * @param idMap 公司ID
     * @return  活动列表
     */
    List<Activity> getActivityByCompanyId(Map idMap);

    /**
     * 根据条件获取活动
     * @param page  相关参数实体类
     * @return  活动列表
     */
    List<Activity> getActivityByPage(Page page);

    /**
     * 获取还未结束报名的活动
     * 按照活动开始时间排序，只取前3个
     * @return  活动列表
     */
    List<Activity> getRecentActivity();

    /**
     * 添加一个活动
     * @param   activity    欲插入的活动
     * @return 0：添加成功 1：添加失败
     * @date        2018/10/17 18:55
    */
    Integer insertActivity(Activity activity);
    /**
     * 根据id删除Activity
     * @param   id  欲删除活动的ID
     * @return  0：删除成功  1：删除失败
     * @date        2018/10/17 18:53
    */
    Integer deleteActivityByID(Integer id);
}