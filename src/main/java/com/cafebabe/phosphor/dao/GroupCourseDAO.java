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
     * @return 0 false | 1 true
     */
    Integer insertGroupCourse(GroupCourse groupCourse);

    /**
     * 更新套餐的课程内容
     * @param groupCourse 套餐课程的实体类
     * @return 0 false | 1 true
     */
    @SuppressWarnings("unused")
    Integer updateGroupCourse(GroupCourse groupCourse);

    /**
     * 删除套餐的课程
     * @param courseId 课程编号
     * @return 0 false | 1 true
     */
    @SuppressWarnings("unused")
    Integer removeGroupCourse(Integer courseId);

    /**
     * 查询套餐的所有课程
     * @param groupId 套餐编号
     * @return 获取课程套餐的列表
     */
    List<GroupCourse> getGroupCourse(Integer groupId);
}