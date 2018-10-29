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

    List<Activity> getActivityByCompanyId(Integer companyId, Integer activityId);

    List<Activity> getRecentActivity();

    Page getActivityInfoByPage(Integer pageIndex, Integer pageSize, String key, String ascOrDesc, String title);

    Integer getActivityCount();

    Activity getActivityByID(Integer id);

    Integer insertActivity(Activity activity);

    Integer deleteActivityByID(Integer id);

}
