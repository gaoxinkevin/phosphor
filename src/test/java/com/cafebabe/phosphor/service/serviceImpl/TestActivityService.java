package com.cafebabe.phosphor.service.serviceImpl;

import com.cafebabe.phosphor.dao.ActivityDAO;
import com.cafebabe.phosphor.model.entity.Activity;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestActivityService {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    ActivityDAO activityDAO = (ActivityDAO) beanFactory.getBean("activityDAO");

    @Test
    public void testGetActivityAll(){
        List<Activity> activityList = activityDAO.getActivityAll();
        activityList.forEach(System.out::println);
    }
}
