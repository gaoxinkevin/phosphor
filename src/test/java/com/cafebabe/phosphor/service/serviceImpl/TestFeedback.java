package com.cafebabe.phosphor.service.serviceImpl;

import com.cafebabe.phosphor.dao.FeedbackDAO;
import com.cafebabe.phosphor.model.dto.FeedbackDTO;
import com.cafebabe.phosphor.model.entity.Feedback;
import com.cafebabe.phosphor.util.PageModel;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFeedback {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    FeedbackDAO feedbackDAO = (FeedbackDAO) beanFactory.getBean("feedbackDAO");

    @Test
    public void testGetFeedbackList(){
        PageModel<FeedbackDTO> pageModel = new PageModel<>();
        pageModel.setStartRecord(0);
        pageModel.setSf(10001);
        System.out.println(feedbackDAO.getFeedbackList(pageModel));
    }

    @Test
    public void testInsertFeedback(){
        Feedback feedback =new Feedback();
        feedback.setTeacherId(10001);
        feedback.setParentId(10000);
        feedback.setFeedbackContent("测试评论");
        feedback.setFeedbackStatus(1);
        System.out.println(feedbackDAO.insertFeedback(feedback));
    }

    @Test
    public void testRemoveFeedback(){
        System.out.println(feedbackDAO.removeFeedback(10004));
    }

}
