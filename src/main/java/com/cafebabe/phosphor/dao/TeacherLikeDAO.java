package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.TeacherLike;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: TeacherLikeDAO
 *
 * create_date: 2018/10/17
 *
 * create_time: 09:37
 *
 * description: 教师点赞模块
 **/
public interface TeacherLikeDAO extends MyBatisBaseDao<TeacherLike, Integer> {

    /**
     * 根据教师ID为教师点赞数加一
     * @param teacherId 教师ID
     * @return 受影响的行数
     */
    int updateTeacherLikeCountAdd(Integer teacherId);

    /**
     * 根据教师ID获取该教师点赞数
     * @param teacherId 教师ID
     * @return 点赞数
     */
    int getTeacherLikeCount(Integer teacherId);
}
