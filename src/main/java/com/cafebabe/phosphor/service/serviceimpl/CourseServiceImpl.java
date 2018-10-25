package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.CourseDAO;
import com.cafebabe.phosphor.dao.TypeDAO;
import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.Page;
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
    public Page getAllCourseByPage(Integer pageIndex, Integer pageSize) {
        Page page = new Page();
        page.setTotalRecord(courseDAO.getCourseCount());
        Integer totalPages = (page.getTotalRecord() % page.getPageSize() == 0) ? (page.getTotalRecord() / page.getPageSize()) : ((page.getTotalRecord() / page.getPageSize())+1);
        page.setTotalPages(totalPages);
        page.setCurrentPageCode(pageIndex);
        page.setStartRecord(pageIndex * pageSize);
        page.setEndRecord(pageSize * (pageIndex + 1) - 1);
        List<Course> courseList = courseDAO.getCourseByPage(page);
        page.setModelList(courseList);
        //System.out.println(page.toString());
        return page;
    }

    @Override
    public Integer getCourseCount() {
        return courseDAO.getCourseCount();
    }

    @Override
    public List<Course> getAllCourseInfo() {
        return courseDAO.getAllCourse();
    }


    @Override
    public Course getCourseService(String courseName) {
        return courseDAO.getCourseByName(courseName);
    }

    @Override
    public CourseInfo getCourseInfoService(Integer courseId) {
        return courseDAO.getCourseInfo(courseId);
    }

    @Override
    public CourseInfo getCourseTime(Integer courseId) {
        return courseDAO.getCourseTime(courseId);
    }

    public boolean contrastCourseTime(CourseInfo courseFirst, CourseInfo courseSecond){
        if (courseFirst.getCourseTimeStatus()!= courseSecond.getCourseTimeStatus()){
            return true;
        }else if ( Integer.parseInt(courseFirst.getCourseEndTime().toString())-Integer.parseInt(courseSecond.getCourseStartTime().toString())>0){
            return true;
        }else {
            return false;
        }
    }
}
