package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.model.entity.GroupCourse;

import java.util.List;

/**
 * GroupCourseDAO继承基类
 */
public interface GroupCourseDAO extends MyBatisBaseDao<GroupCourse, Integer> {

    /**
     * 给套餐插入课程
     * @param groupCourse 套餐的课程
     * @return
     */
    Integer insertGroupCourse(GroupCourse groupCourse);

    Integer insertGroupCourses(List<Course> groupCourse);

    /**
     * 删除套餐的课程
     * @param id
     * @return
     */
    Integer removeGroupCourse(Integer id);

    /**
     * 查询套餐的所有课程
     * @param groupId 套餐编号
     * @return
     */
    List<GroupCourse> getGroupCourse(Integer groupId);
}