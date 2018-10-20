package com.cafebabe.phosphor.service.serviceImpl;

import com.cafebabe.phosphor.dao.TeacherCourseDAO;
import com.cafebabe.phosphor.dao.TeacherDAO;
import com.cafebabe.phosphor.dao.TeacherLikeDAO;
import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.TeacherService;
import com.cafebabe.phosphor.service.serviceimpl.TeacherServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestTeacherService {

    BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    TeacherDAO teacherDAO = (TeacherDAO) beanFactory.getBean("teacherDAO");
    TeacherLikeDAO teacherLikeDAO = (TeacherLikeDAO) beanFactory.getBean("teacherLikeDAO");
    TeacherCourseDAO teacherCourseDAO =(TeacherCourseDAO) beanFactory.getBean("teacherCourseDAO");
    TeacherServiceImpl service =(TeacherServiceImpl) beanFactory.getBean("teacherServiceImpl");

    @Test
    public void testGetTeacherList() {
        List<Teacher> list = teacherDAO.getTeacherList();
        List<Teacher> list2 = service.getTeacherList();
        System.out.println(service.getTeacherById(10000));
        for (Teacher t : list) {
            System.out.println(t);
        }
        System.out.println(list2);
    }

    @Test
    public void testTeacherLike() {
        System.out.println(teacherLikeDAO.updateTeacherLikeCountAdd(10001));
    }
    @Test
    public void testTeacherCourseGetTeacherId(){
        System.out.println(teacherCourseDAO.getTeacherId(10000));
    }
}
