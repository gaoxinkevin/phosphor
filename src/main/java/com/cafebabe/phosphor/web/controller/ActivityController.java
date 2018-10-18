package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Activity;
import com.cafebabe.phosphor.service.serviceimpl.ActivityServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author:         Ningtao Liu
 * @CreateDate:     2018/10/18 10:52
 * @Version:        1.0
 */

@Controller
@CrossOrigin
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private final ActivityServiceImpl activityService;
    public ActivityController(ActivityServiceImpl activityService){
        this.activityService = activityService;
    }

    @RequestMapping("activityAll")
    @ResponseBody
    public JsonResponse getActivityAll(){
        List<Activity> activityList = activityService.getActivityAll();
        return new JsonResponse(200, "success", activityList);
    }
}
