package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.dto.PageCourse;
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
     * 分页查询
     * @param pageIndex 页码
     * @param pageSize 每页显示数量
     * @return 分页后的课程信息
     */
    Page getAllCourseByPage(Integer pageIndex, Integer pageSize);

    /**
     * 得到课程总数
     * @return 课程总数
     */
    Integer getCourseCount();

    /**
     * 得到某课程所有信息
     * @return 课程所有信息
     */
    List<Course> getAllCourseInfo ();


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

    /**
     * 获得某课程时间信息
     * @param courseId 课程id
     * @return 课程时间
     */
    CourseInfo getCourseTime(Integer courseId);

    /**
     * 得到所有课程
     * @return 课程列表
     */
    List<Course> getAllCourse();

    /**
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Course> getCourseByType(Integer pageIndex, Integer pageSize);

    /**
     * 查询插入课程是否与课程列表里面有时间冲突,如果有冲突,返回第一个有冲突的课程
     * @param courseInfoList 课程列表
     * @param courseId 课程编号
     * @return 有冲突就返回冲突的课程,没有就返回null
     */
    CourseInfo getConflictCourseInfo(List<CourseInfo> courseInfoList, Integer courseId);
}
