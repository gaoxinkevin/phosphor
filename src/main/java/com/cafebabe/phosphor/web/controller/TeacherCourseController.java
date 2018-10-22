package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.service.TeacherCourseService;
import com.cafebabe.phosphor.service.serviceimpl.TeacherCourseServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: TeacherCourseServiceImpl
 * <p>
 * create_date: 2018/10/17
 * <p>
 * create_time: 16:19
 * <p>
 * description: 教师课程关联的业务控制层
 **/
@Controller
@CrossOrigin
@RequestMapping("teacherCourse")
public class TeacherCourseController {

    @Autowired
    private final TeacherCourseServiceImpl teacherCourseService;

    public TeacherCourseController(TeacherCourseServiceImpl teacherCourseService) {
        this.teacherCourseService = teacherCourseService;
    }

    @RequestMapping("getTeacherId")
    @ResponseBody
    public JsonResponse getTeacherId(@RequestBody Course course){
        return new JsonResponse(200,"success",teacherCourseService.getTeacherId(course.getCourseId()));
    }

}
