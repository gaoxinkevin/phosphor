package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.entity.Course;

import java.util.List;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: CourseService
 *
 * create_date: 2018/10/17
 *
 * create_time: 15:36
 *
 * description: 课程信息数据处理
 **/
public interface CourseService {

    /**
     * 查询所有课程
     * @return 课程列表
     */
    List<Course> getAllCourseService();

    /**
     * 根据名称查询某课程
     * @return 课程
     */
    Course getCourseService(String courseName);

    /**
     * 查询某课程所有信息
     * @param courseId 课程id
     * @return 课程信息
     */
    CourseInfo getCourseInfoService(Integer courseId);
}
