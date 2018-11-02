package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.ActivitySummary;

import java.util.List;

/**
 * @Description:    活动总结DAO层
 * @Author:         Ningtao Liu
 * @CreateDate:     2018/11/2 14:21
 * @Version:        1.0
 */
public interface ActivitySummaryDAO extends MyBatisBaseDao<ActivitySummary, Integer> {

    /**
     * 根据Activity的ID获取ActivitySummary
     * @param   actId   活动ID
     * @return  ActivitySummary
     * @date        2018/10/17 19:02
    */
    List<ActivitySummary> getActivitySummaryByActID(Integer actId);


}