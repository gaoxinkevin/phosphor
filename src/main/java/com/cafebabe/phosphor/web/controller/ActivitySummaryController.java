package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.ActivitySummary;

import com.cafebabe.phosphor.service.serviceimpl.ActivitySummaryServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:    活动控制层
 * @Author:         Ningtao Liu
 * @CreateDate:     2018/11/2 14:24
 * @Version:        1.0
 */

@CrossOrigin
@Controller
@RequestMapping("/activitySummary")
public class ActivitySummaryController {

    @Autowired
    private final ActivitySummaryServiceImpl activitySummaryService;

    public ActivitySummaryController(ActivitySummaryServiceImpl activitySummaryService){this.activitySummaryService = activitySummaryService;}

    @RequestMapping("getActivitySummaryByActId")
    @ResponseBody
    public JsonResponse getActivitySummaryByActId(Integer activityId){
        List<ActivitySummary> activitySummaryList = activitySummaryService.getActivitySumByActId(activityId);
        if(null != activitySummaryList){
            return new JsonResponse(200, "success", activitySummaryList);
        }
        else {
            return new JsonResponse(400, "error", null);
        }
    }
}
