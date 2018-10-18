package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ActivityDAO;
import com.cafebabe.phosphor.model.entity.Activity;
import com.cafebabe.phosphor.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:    活动Service层实现类
 * @Author:         Ningtao Liu
 * @CreateDate:     2018/10/18 11:01
 * @Version:        1.0
 */

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private final ActivityDAO activityDAO;

    public ActivityServiceImpl(ActivityDAO activityDAO){
        this.activityDAO = activityDAO;
    }

    @Override
    public List<Activity> getActivityAll() {
        return activityDAO.getActivityAll();
    }

    @Override
    public Activity getActivityByID(Integer id) {
        return activityDAO.getActivityByID(id);
    }

    @Override
    public Integer insertActivity(Activity activity) {
        return activityDAO.insertActivity(activity);
    }

    @Override
    public Integer deleteActivityByID(Integer id) {
        return activityDAO.deleteActivityByID(id);
    }
}
