package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.FeedbackDAO;
import com.cafebabe.phosphor.dao.ParentDAO;
import com.cafebabe.phosphor.model.dto.FeedbackDTO;
import com.cafebabe.phosphor.model.entity.Feedback;
import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.service.FeedbackService;
import com.cafebabe.phosphor.util.PageModel;
import com.cafebabe.phosphor.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: FeedbackServiceImpl
 * <p>
 * create_date: 2018/10/17
 * <p>
 * create_time: 16:55
 * <p>
 * description: 教师评价Service层的实现类
 **/
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private final FeedbackDAO feedbackDAO;
    @Autowired
    private final ParentDAO parentDAO;

    public FeedbackServiceImpl(FeedbackDAO feedbackDAO, ParentDAO parentDAO) {
        this.feedbackDAO = feedbackDAO;
        this.parentDAO = parentDAO;
    }

    @Override
    public PageModel<FeedbackDTO> getFeedbackList(PageModel<FeedbackDTO> pageModel) {
        pageModel.setTotalRecord(feedbackDAO.getFeedbackCount(pageModel.getSf()));
        pageModel.setPageSize(5);
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize());
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ?
                pageModel.getTotalRecord() / pageModel.getPageSize() :
                pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        List<FeedbackDTO> feedbackDTOList;
        int currentPageCode = pageModel.getCurrentPageCode();
        int teacherId = pageModel.getSf();
        if (currentPageCode != pageModel.getTotalPages()) {
            if (0 != RedisUtil.getList("getFeedbackList" + teacherId + (currentPageCode)).size()) {
                feedbackDTOList = RedisUtil.getList("getFeedbackList" + teacherId + currentPageCode);
            } else {
                RedisUtil.setList("getFeedbackList" + teacherId + currentPageCode, feedbackDAO.getFeedbackList(pageModel));
                feedbackDTOList = RedisUtil.getList("getFeedbackList" + teacherId + currentPageCode);
            }
        } else {
            feedbackDTOList = feedbackDAO.getFeedbackList(pageModel);
        }
        for (FeedbackDTO feedbackDTO : feedbackDTOList) {
            int nameLength = feedbackDTO.getParentName().substring(1).length();
            String name = "";
            for (int i = 0; i < nameLength; i++) {
                name += "*";
            }
            feedbackDTO.setParentName(feedbackDTO.getParentName().substring(0, 1) + name);
            feedbackDTO.setParentPhone(feedbackDTO.getParentPhone().substring(0, 1) + "******" +
                    feedbackDTO.getParentPhone().substring(7));
        }
        pageModel.setModelList(feedbackDTOList);
        return pageModel;
    }

    @Override
    public int insertFeedback(Feedback feedback) {
        Parent parent = parentDAO.getAllInfoAboutParentDao(feedback.getFeedbackSf());
        feedback.setFeedbackStatus(1);
        feedback.setParentId(parent.getParentId());
        return feedbackDAO.insertFeedback(feedback);
    }

    @Override
    public int removeFeedback(Integer feedbackId) {
        return feedbackDAO.removeFeedback(feedbackId);
    }
}
