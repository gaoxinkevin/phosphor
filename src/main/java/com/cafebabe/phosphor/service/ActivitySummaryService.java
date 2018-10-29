package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.entity.ActivitySummary;

import java.util.List;

/**
 * @Description:    ActivitySummary Service层
 * @Author:         Ningtao Liu
 * @CreateDate:     2018/10/25 15:23
 * @Version:        1.0
 */
public interface ActivitySummaryService {
    /**
     * 根据Activity的ID获取ActivitySummary
     * @param activityID
     * @return
     */
    List<ActivitySummary> getActivitySumByActId(Integer activityID);
}
