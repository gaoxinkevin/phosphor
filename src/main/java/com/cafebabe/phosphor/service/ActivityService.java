package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.ActivityInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.entity.Activity;

import java.util.List;

/**
 * @Description:    活动service层
 * @Author:         Ningtao Liu
 * @CreateDate:     2018/10/18 10:55
 * @Version:        1.0
 */
public interface ActivityService {
    List<Activity> getActivityAll();

    List<ActivityInfo> getActivityInfoAll();

    Page getActivityInfoByPage(Integer pageIndex, Integer pageSize);

    Integer getActivityCount();

    Activity getActivityByID(Integer id);

    Integer insertActivity(Activity activity);

    Integer deleteActivityByID(Integer id);

    List<ActivityInfo> merge(List<Activity> activityList);
}