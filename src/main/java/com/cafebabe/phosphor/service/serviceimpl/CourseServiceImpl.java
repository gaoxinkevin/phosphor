package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.CourseDAO;
import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: CourseServiceImpl
 *
 * create_date: 2018/10/17
 *
 * create_time: 15:49
 *
 * description: CourseService实现类
 **/

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private final CourseDAO courseDAO;

    public CourseServiceImpl(CourseDAO courseDAO){
        this.courseDAO = courseDAO;
    }


    @Override
    public List<Course> getAllCourseService() {
        return courseDAO.getAllCourse();
    }

    @Override
    public Course getCourseService(String courseName) {
        return courseDAO.getCourseByName(courseName);
    }
}
