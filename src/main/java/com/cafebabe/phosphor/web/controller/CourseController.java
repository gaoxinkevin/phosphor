package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.dto.PageCourse;
import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.model.entity.Suggest;
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

    /**
     * 获得课程详细信息
     * @param courseId 课程id
     * @return 课程详细
     */
    @ResponseBody
    @RequestMapping("/findCourseInfo/{courseId}")
    public JsonResponse findCourseInfo(@PathVariable Integer courseId){
        CourseInfo courseInfo = courseService.getCourseInfoService(courseId);
        return new JsonResponse(20000,"成功",courseInfo);
    }

    /**
     * 获得课程所有评价
     * @param courseId 课程id
     * @return 课程评价
     */
    @ResponseBody
    @RequestMapping("/getSuggest/{courseId}")
    public JsonResponse getSuggest(@PathVariable Integer courseId){
        List<Suggest> suggestList = courseService.getSuggestByCourse(courseId);
        return new JsonResponse(20000,"成功",suggestList);
    }

    /**
     * 获得所有课程
     * @return 课程集合
     */
    @ResponseBody
    @GetMapping("/getCourseList")
    public JsonResponse getCourseList(){
        List<Course> courseList = courseService.getAllCourseInfo();
        return new JsonResponse(20000,"成功",courseList);
    }

    /**
     * 分页查询课程
     * @param pageIndex 页码
     * @param pageSize 每页展示数量
     * @return 分页后的课程
     */
    @ResponseBody
    @RequestMapping("/getCourseListByPage")
    public JsonResponse getCourseListByPage(Integer pageIndex, Integer pageSize){
        Page page = courseService.getAllCourseByPage(pageIndex,pageSize);
        return new JsonResponse(200, "success", page);
    }

    @ResponseBody
    @RequestMapping("/getCourseListByType")
    public JsonResponse getCourseListByType(Integer pageIndex, Integer pageSize,String orderField,Integer typeId){
        PageCourse pageCourse = courseService.getCourseByType(pageIndex,pageSize,orderField,typeId);
        return new JsonResponse(200,"success",pageCourse);
    }

    /**
     * 课程收藏
     * @return 课程集合
     */
    @ResponseBody
    @RequestMapping("/getCommendCourseList")
    public JsonResponse getCommendCourseList(){
        List<Course> courseList = courseService.getAllCourseInfo();
        return new JsonResponse(200, "success", courseList);
    }

    /**
     * 获得所有课程
     * @return 课程列表
     */
    @ResponseBody
    @RequestMapping("/getAllCourse")
    public JsonResponse getAllCourse(){
        List<Course> courseList = courseService.getAllCourse();
        return new JsonResponse(200, "success", courseList);
    }

    @ResponseBody
    @RequestMapping("/addSuggest")
    public JsonResponse addSuggest(Suggest suggest){
        Integer row = courseService.insertSuggest(suggest);
        return new JsonResponse(200, "success", row);
    }

}
