package com.cafebabe.phosphor.service;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: TeacherLikeService
 * <p>
 * create_date: 2018/10/17
 * <p>
 * create_time: 16:34
 * <p>
 * description: 教师点赞 Service
 **/
public interface TeacherLikeService {

    /**
     * 根据教师ID为教师点赞数加一
     *
     * @param teacherId 教师ID
     * @return 受影响的行数
     */
    int updateTeacherLikeCountAdd(Integer teacherId);

    /**
     * 根据教师ID获取该教师点赞数
     *
     * @param teacherId 教师ID
     * @return 点赞数
     */
    int getTeacherLikeCount(Integer teacherId);
}
