package com.cafebabe.phosphor.service.serviceImpl;

import com.cafebabe.phosphor.dao.TypeDAO;
import com.cafebabe.phosphor.model.entity.Type;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTypeService {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    TypeDAO typeDAO = (TypeDAO) beanFactory.getBean("typeDAO");

    @Test
    public void TestGetType(){
        Type type = typeDAO.selectByPrimaryKey(10000);
        System.out.println(type);
    }
}
