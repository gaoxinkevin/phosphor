package com.cafebabe.phosphor.service.serviceImpl;

import com.cafebabe.phosphor.dao.CourseDAO;
import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.dto.PageCourse;
import com.cafebabe.phosphor.model.entity.Course;
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
    Integer pageIndex=2;
    Integer pageSize=2;
    @Test
    public void TestGetCourseInfo(){
        CourseInfo courseInfo = courseDAO.getCourseInfo(10016);
        System.out.println(courseInfo);
    }

    @Test
    public void TestGetCourseType(){
        PageCourse pageCourse = new PageCourse();
        pageCourse.setOrderField("priceAsc");
        pageCourse.setTypeId(null);
        pageCourse.setTotalRecord(courseDAO.getCourseCount());
        Integer totalPages = (pageCourse.getTotalRecord() % pageCourse.getPageSize() == 0) ? (pageCourse.getTotalRecord() / pageCourse.getPageSize()) : ((pageCourse.getTotalRecord() / pageCourse.getPageSize())+1);
        pageCourse.setTotalPages(totalPages);
        pageCourse.setCurrentPageCode(pageIndex);
        pageCourse.setStartRecord(pageIndex * pageSize);
        pageCourse.setEndRecord(pageSize * (pageIndex + 1) - 1);
        List<Course> courseList = courseDAO.getCourseByType(pageCourse);
        pageCourse.setModelList(courseList);

    }


    @Test
    public void TestGetAllCourse(){
        List<Course> courseList = courseDAO.getAllCourse();
        courseList.forEach(System.out::println);
    }
}
