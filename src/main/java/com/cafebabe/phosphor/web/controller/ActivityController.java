package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.ActivityInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.entity.Activity;
import com.cafebabe.phosphor.service.serviceimpl.ActivityServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("getActivityAll")
    @ResponseBody
    public JsonResponse getActivityAll(){
        List<Activity> activityList = activityService.getActivityAll();
        return new JsonResponse(200, "success", activityList);
    }

    @RequestMapping("getActivityInfoAll")
    @ResponseBody
    public JsonResponse getActivityInfoAll(){
        List<ActivityInfo> activityInfoList = activityService.getActivityInfoAll();
        return new JsonResponse(200, "success", activityInfoList);
    }

    @RequestMapping(value = "getActivityInfoByPage", method = RequestMethod.POST)
    @ResponseBody
    public  JsonResponse getActivityInfoByPage(Integer pageIndex, Integer pageSize, String key, String ascOrDesc, String title){
        Page page = activityService.getActivityInfoByPage(pageIndex, pageSize, key, ascOrDesc, title);
        return new JsonResponse(200, "success", page);
    }


    @RequestMapping("getActivityDetail")
    @ResponseBody
    public JsonResponse getActivityDetail(Integer activityId){
        Activity activity = activityService.getActivityByID(activityId);
        return new JsonResponse(200, "success", activity);
    }


    /**
     * 根据公司id获取该公司的其他活动
     * @param companyId 公司ID
     * @return JSON
     */
    @RequestMapping("getActivityByCompanyId")
    @ResponseBody
    public JsonResponse getActivityByCompanyId(Integer companyId, Integer activityId){
        System.out.println("companyId= "+companyId+"; activityId="+activityId);
        List<Activity> activityList = activityService.getActivityByCompanyId(companyId, activityId);
        if(null != activityList){
            return new JsonResponse(200, "success", activityList);
        }
        else{
            return new JsonResponse(404, "not found", null);
        }
    }


    /**
     * 获取近期热门活动
     * 按照开始时间排序，最多只取前3个
     * @return  JSON
     */
    @RequestMapping("getRecentActivity")
    @ResponseBody
    public JsonResponse getRecentActivity(){
        List<Activity> recentActivity = activityService.getRecentActivity();
        if(null != recentActivity){
            System.out.println(recentActivity);
            return new JsonResponse(200, "success", recentActivity);
        }
        else {
            return new JsonResponse(400, "error", null);
        }
    }
    
}
