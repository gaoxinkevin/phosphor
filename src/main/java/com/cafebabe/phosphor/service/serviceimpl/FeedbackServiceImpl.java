package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.FeedbackDAO;
import com.cafebabe.phosphor.model.dto.FeedbackDTO;
import com.cafebabe.phosphor.model.entity.Feedback;
import com.cafebabe.phosphor.service.FeedbackService;
import com.cafebabe.phosphor.util.PageModel;
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
    public PageModel<FeedbackDTO> getFeedbackList(PageModel<FeedbackDTO> pageModel) {
        pageModel.setTotalRecord(feedbackDAO.getFeedbackCount(pageModel.getSf()));
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setModelList(feedbackDAO.getFeedbackList(pageModel));
        System.out.println(pageModel);
        return pageModel;
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
