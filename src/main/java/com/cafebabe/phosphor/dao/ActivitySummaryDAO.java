package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.ActivitySummary;

import java.util.List;

/**
 * ActivitySummaryDAO继承基类
 */
public interface ActivitySummaryDAO extends MyBatisBaseDao<ActivitySummary, Integer> {
    /**
     * 根据id获取ActivitySummary
     * @param   id
     * @return  ActivitySummary
     * @date        2018/10/17 19:01
    */
    ActivitySummary getActivitySummaryByID(Integer id);

    /**
     * 根据Activity的ID获取ActivitySummary
     * @param   actId
     * @return  ActivitySummary
     * @date        2018/10/17 19:02
    */
    List<ActivitySummary> getActivitySummaryByActID(Integer actId);

    /**
     * 添加ActivitySummary
     * @param   activitySummary
     * @return  0:添加成功 1：添加失败
     * @date        2018/10/17 19:04
    */
    Integer insertActivitySummary(ActivitySummary activitySummary);

    /**
     * 根据ID删除ActivitySummary
     * @param id
     * @return 0:删除成功 1：删除失败
     * @date        2018/10/17 19:07
    */
    Integer deleteActivitySummaryByID(Integer id);

    /**
     * 根据Activity的ID删除Activity
     * @param   actID
     * @return    0:删除成功 1:删除失败
     * @date        2018/10/17 19:11
    */
    Integer deleteActivitySummaryByActID(Integer actID);
}