package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.Feedback;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: FeedbackDAO
 *
 * create_date: 2018/10/17
 *
 * create_time: 09:38
 *
 * description: 教师评价模块
 **/
public interface FeedbackDAO extends MyBatisBaseDao<Feedback, Integer> {

    /**
     * 根据教师ID获取该教师所有评价
     * @param teacherId 教师ID
     * @return 该教师所有评价
     */
    List<Feedback> getFeedbackList(Integer teacherId);

    /**
     * 插入新的教师评价
     * @param feedback 评价
     * @return 受影响的行数
     */
    int insertFeedback(Feedback feedback);

    /**
     * 根据评价ID删除评价
     * @param feedbackId 评价ID
     * @return 受影响的行数
     */
    int removeFeedback(Integer feedbackId);

}
