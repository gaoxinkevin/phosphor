package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.dto.PageCourse;
import com.cafebabe.phosphor.model.entity.Course;

import java.util.List;
import java.util.Map;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: CourseDAO
 *
 * create_date: 2018/10/17
 *
 * create_time: 15:58
 *
 * description: 课程接口
 **/
public interface CourseDAO extends MyBatisBaseDao<Course, Integer> {
    /**
     * 查询所有课程
     * @return 课程列表
     */
    List<Course> getCourseByNewTime();

    /**
     * 根据课程名查询课程
     * @param courseName 课程名
     * @return 课程
     */
    Course getCourseByName(String courseName);

    /**
     * 查询某个公司的课程
     * @param companyName 公司名称
     * @return 课程列表
     */
    List<CourseInfo> getCourseByCompanyName(String companyName);

    /**
     * 根据主键查询某课程所有信息
     * @param courseId 课程id
     * @return 课程信息
     */
    CourseInfo getCourseInfo (Integer courseId);

    /**
     * 分页查询课程
     * @param page 页码信息
     * @return 课程列表
     */
    List<Course> getCourseByPage(Page page);

    /**
     * 获得课程总记录数
     * @return 课程总数
     */
    Integer getCourseCount();

    /**
     * 获得课程时间信息
     * @return 时间信息
     */
    CourseInfo getCourseTime(Integer courseId);

    /**
     * 根据类别查询课程并排序并分页
     * @param pageCourse  课程条件
     * @return 课程信息
     */
    List<Course> getCourseByType(PageCourse pageCourse);

    /**
     * 查询所有课程
     * @return
     */
    List<Course> getAllCourse();


}