package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.FeedbackDAO;
import com.cafebabe.phosphor.model.entity.Feedback;
import com.cafebabe.phosphor.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: FeedbackServiceImpl
 *
 * create_date: 2018/10/17
 *
 * create_time: 16:55
 *
 * description: 教师评价Service层的实现类
 **/
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private final FeedbackDAO feedbackDAO;

    public FeedbackServiceImpl(FeedbackDAO feedbackDAO) {
        this.feedbackDAO = feedbackDAO;
    }

    @Override
    public List<Feedback> getFeedbackList(Integer teacherId) {
        return feedbackDAO.getFeedbackList(teacherId);
    }

    @Override
    public int insertFeedback(Feedback feedback) {
        return feedbackDAO.insertFeedback(feedback);
    }

    @Override
    public int removeFeedback(Integer feedbackId) {
        return feedbackDAO.removeFeedback(feedbackId);
    }
}
