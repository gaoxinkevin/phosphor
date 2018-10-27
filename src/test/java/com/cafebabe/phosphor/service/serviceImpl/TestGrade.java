package com.cafebabe.phosphor.service.serviceImpl;

import com.cafebabe.phosphor.dao.GradeDAO;
import com.cafebabe.phosphor.model.dto.GradeInfo;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestGrade {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    GradeDAO gradeDAO = (GradeDAO) beanFactory.getBean("gradeDAO");

    @Test
    public void TestGetGradeByChild(){
        List<GradeInfo> gradeInfoList = gradeDAO.getGradeByChild(10000);
        gradeInfoList.forEach(System.out::println);
    }
}
