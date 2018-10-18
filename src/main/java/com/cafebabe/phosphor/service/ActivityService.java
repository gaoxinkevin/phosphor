package com.cafebabe.phosphor.service;

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

    Activity getActivityByID(Integer id);

    Integer insertActivity(Activity activity);

    Integer deleteActivityByID(Integer id);
}
