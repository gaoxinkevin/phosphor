package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.TeacherCourseDAO;
import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.service.TeacherCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: TeacherCourseServiceImpl
 * <p>
 * create_date: 2018/10/17
 * <p>
 * create_time: 15:50
 * <p>
 * description: 教师课程关联Service层的实现类
 **/
@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {

    private final TeacherCourseDAO teacherCourseDAO;

    @Autowired
    public TeacherCourseServiceImpl(TeacherCourseDAO teacherCourseDAO) {
        this.teacherCourseDAO = teacherCourseDAO;
    }

    @Override
    public Integer getTeacherId(Integer courseId) {
        return teacherCourseDAO.getTeacherId(courseId);
    }

    @Override
    public List<Course> getCoursesByTeacherId(Integer teacherId) {
        return teacherCourseDAO.getCoursesByTeacheerId(teacherId);
    }
}
