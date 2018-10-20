package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.TeacherCourse;

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

}
