package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ActivitySummaryDAO;
import com.cafebabe.phosphor.model.entity.ActivitySummary;
import com.cafebabe.phosphor.service.ActivitySummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitySummaryServiceImpl implements ActivitySummaryService {

    @Autowired
    private final ActivitySummaryDAO activitySummaryDAO;

    public ActivitySummaryServiceImpl(ActivitySummaryDAO activitySummaryDAO) {
        this.activitySummaryDAO = activitySummaryDAO;
    }


    @Override
    public List<ActivitySummary> getActivitySumByActId(Integer activityID) {
        return activitySummaryDAO.getActivitySummaryByActID(activityID);
    }
}
