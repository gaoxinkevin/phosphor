package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.service.serviceimpl.CourseServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: CourseController
 *
 * create_date: 2018/10/17
 *
 * create_time: 15:34
 *
 * description: 课程信息页面分发
 **/

@Controller
@CrossOrigin
@RequestMapping("/course")
public class CourseController {

    private final CourseServiceImpl courseService;

    @Autowired
    public CourseController(CourseServiceImpl courseService){
        this.courseService = courseService;
    }

    @ResponseBody
    @RequestMapping("/findCourseInfo/{courseId}")
    public JsonResponse findCourseInfo(@PathVariable Integer courseId){
        CourseInfo courseInfo = courseService.getCourseInfoService(courseId);
        return new JsonResponse(20000,"成功",courseInfo);
    }

    @ResponseBody
    @GetMapping("/getCourseList")
    public JsonResponse getCourseList(){
        List<Course> courseList = courseService.getAllCourseInfo();
        return new JsonResponse(20000,"成功",courseList);
    }

    @ResponseBody
    @RequestMapping("/getCourseListByPage")
    public JsonResponse getCourseListByPage(Integer pageIndex, Integer pageSize){
        Page page = courseService.getAllCourseByPage(pageIndex,pageSize);
        return new JsonResponse(200, "success", page);
    }
}
