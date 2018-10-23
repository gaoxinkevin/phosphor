package com.cafebabe.phosphor.service.serviceImpl;

import com.cafebabe.phosphor.dao.CourseDAO;
import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.Page;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: TestCourseService
 *
 * create_date: 2018/10/22
 *
 * create_time: 9:49
 *
 * description: 测试course接口方法
 **/
public class TestCourseService {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    CourseDAO courseDAO = (CourseDAO) beanFactory.getBean("courseDAO");

    @Test
    public void TestGetCourseInfo(){
        CourseInfo courseInfo = courseDAO.getCourseInfo(10000);
        System.out.println(courseInfo);
    }

    @Test
    public void TestGetCourseByPage(){
        /*Page page = new Page(2,2,2,2,2,2,List<>)
        List<CourseInfo> courseInfoList = courseDAO.getCourseByPage()*/
    }
}
