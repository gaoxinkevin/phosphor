package com.cafebabe.phosphor.service.serviceImpl;

import com.cafebabe.phosphor.dao.SuggestDAO;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSuggest {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    SuggestDAO suggestDAO = (SuggestDAO) beanFactory.getBean("suggestDAO");

    @Test
    public void TestGetSuggestByCourse(){
        suggestDAO.getSuggestByCourse(10000).forEach(System.out::println);
    }
}
