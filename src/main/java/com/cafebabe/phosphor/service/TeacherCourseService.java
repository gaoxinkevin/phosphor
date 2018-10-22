package com.cafebabe.phosphor.service;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: TeacherCourceService
 *
 * create_date: 2018/10/17
 *
 * create_time: 15:47
 *
 * description: 教师课程关联 Service
 **/
public interface TeacherCourseService {

    /**
     * 根据课程ID查找授课教师ID
     * @param courseId 课程ID
     * @return 教师ID
     */
    Integer getTeacherId(Integer courseId);

}
