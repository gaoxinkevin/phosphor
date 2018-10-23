package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.model.entity.TeacherCourse;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: TeacherCourseDAO
 *
 * create_date: 2018/10/17
 *
 * create_time: 09:35
 *
 * description: 教师课程关联模块
 **/
public interface TeacherCourseDAO extends MyBatisBaseDao<TeacherCourse, Integer> {

    /**
     * 根据课程ID获取教师ID
     * @param courseId 课程ID
     * @return 教师ID
     */
    Integer getTeacherId(Integer courseId);

    /**
     * 根据教师id获取其教授的课程
     * @param teacherId 教师Id
     * @return  教师教授课程的集合
     */
    List<Course> getCoursesByTeacheerId(Integer teacherId);

}
