package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Feedback;
import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.serviceimpl.FeedbackServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: FeedbackController
 *
 * create_date: 2018/10/17
 *
 * create_time: 16:58
 *
 * description: 教师评价的业务控制层
 **/
@Controller
@CrossOrigin
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private final FeedbackServiceImpl feedbackService;

    public FeedbackController(FeedbackServiceImpl feedbackService) {
        this.feedbackService = feedbackService;
    }

    @RequestMapping("getFeedbackList")
    @ResponseBody
    public JsonResponse getFeedbackList(@RequestBody Teacher teacher){
        return new JsonResponse(200,"success",feedbackService.getFeedbackList(teacher.getTeacherId()));
    }

    @RequestMapping("insertFeedback")
    @ResponseBody
    public JsonResponse insertFeedback(@RequestBody Feedback feedback){
        return new JsonResponse(200,"success",feedbackService.insertFeedback(feedback));
    }

    @RequestMapping("removeFeedback")
    @ResponseBody
    public JsonResponse removeFeedback(@RequestBody Feedback feedback){
        return new JsonResponse(200,"success",feedbackService.removeFeedback(feedback.getFeedbackId()));
    }

}
