package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.dto.FeedbackDTO;
import com.cafebabe.phosphor.model.entity.Feedback;
import com.cafebabe.phosphor.util.PageModel;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: FeedbackDAO
 * <p>
 * create_date: 2018/10/17
 * <p>
 * create_time: 09:38
 * <p>
 * description: 教师评价模块
 **/
public interface FeedbackDAO extends MyBatisBaseDao<Feedback, Integer> {

    /**
     * 根据教师ID获取该教师所有评价
     *
     * @param pageModel 评价的分页信息
     * @return 该教师所有评价
     */
    List<FeedbackDTO> getFeedbackList(PageModel<FeedbackDTO> pageModel);

    /**
     * 根据教师ID获取该教师评价数目
     *
     * @param teacherId 教师ID
     * @return 评价数目
     */
    Integer getFeedbackCount(Integer teacherId);

    /**
     * 插入新的教师评价
     *
     * @param feedback 评价
     * @return 受影响的行数
     */
    int insertFeedback(Feedback feedback);

    /**
     * 根据评价ID删除评价
     *
     * @param feedbackId 评价ID
     * @return 受影响的行数
     */
    int removeFeedback(Integer feedbackId);

}
