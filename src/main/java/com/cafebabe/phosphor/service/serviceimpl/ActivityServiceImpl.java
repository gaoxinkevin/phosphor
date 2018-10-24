package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ActivityDAO;
import com.cafebabe.phosphor.dao.TeacherDAO;
import com.cafebabe.phosphor.model.dto.ActivityInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.entity.Activity;
import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private final TeacherDAO teacherDAO;

    public ActivityServiceImpl(ActivityDAO activityDAO, TeacherDAO teacherDAO){
        this.activityDAO = activityDAO;
        this.teacherDAO = teacherDAO;
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

    @Override
    public List<ActivityInfo> getActivityInfoAll() {
        List<Activity> activityList = activityDAO.getActivityAll();
        return merge(activityList);
    }

    @Override
    public Page getActivityInfoByPage(Integer pageIndex, Integer pageSize) {
        Page page = new Page();
        page.setTotalRecord(activityDAO.getActivityCount());
        Integer totalPages = (page.getTotalRecord() % page.getPageSize() == 0) ? (page.getTotalRecord() / page.getPageSize()) : ((page.getTotalRecord() / page.getPageSize())+1);
        page.setTotalPages(totalPages);
        page.setCurrentPageCode(pageIndex);
        page.setStartRecord(pageIndex * pageSize);
        page.setEndRecord(pageSize * (pageIndex + 1) - 1);
        List<Activity> activityList = activityDAO.getActivityByPage(page);
        page.setModelList(activityList);
        return page;
    }

    @Override
    public Integer getActivityCount() {
       return activityDAO.getActivityCount();
    }

    @Override
    public List<Activity> getActivityByCompanyId(Integer companyId, Integer activityId) {
        Map<String, Integer> idMap = new HashMap<>();
        idMap.put("companyId", companyId);
        idMap.put("activityId", activityId);
        return activityDAO.getActivityByCompanyId(idMap);
    }

    @Override
    public List<Activity> getRecentActivity() {
        return activityDAO.getRecentActivity();
    }

    public List<ActivityInfo> merge(List<Activity> activityList) {
        List<ActivityInfo> activityInfoList = new ArrayList<>();
        for(int i = 0; i < activityList.size(); i++){
            Activity activity =activityList.get(i);
            Teacher teacher = teacherDAO.selectByPrimaryKey(activity.getTeacherId());
            ActivityInfo activityInfo = new ActivityInfo();
            activityInfo.setActivityId(activity.getActivityId());
            activityInfo.setTeacherId(activity.getTeacherId());
            activityInfo.setTeacherName(teacher.getTeacherName());
            activityInfo.setCompanyName(activity.getCompanyName());
            activityInfo.setCompanyId(activity.getCompanyId());
            activityInfo.setActivityTitle(activity.getActivityTitle());
            activityInfo.setActivityDesc(activity.getActivityDesc());
            activityInfo.setActivityStartTime(activity.getActivityStartTime());
            activityInfo.setActivityEndTime(activity.getActivityEndTime());
            activityInfo.setActivityAddress(activity.getActivityAddress());
            activityInfo.setActivityState(activity.getActivityState());
            activityInfo.setActivityStartTime(activity.getActivityApplyStartTime());
            activityInfo.setActivityApplyEndTime(activity.getActivityApplyEndTime());
            activityInfo.setActivityContent(activity.getActivityContent());
            activityInfo.setActivityPrice(activity.getActivityPrice());
            activityInfo.setActivitySf(activity.getActivitySf());
            activityInfoList.add(activityInfo);
        }
        return activityInfoList;
    }
}
