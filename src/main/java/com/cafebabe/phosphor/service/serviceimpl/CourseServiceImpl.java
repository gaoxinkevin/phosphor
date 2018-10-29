package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.CourseDAO;
import com.cafebabe.phosphor.dao.TypeDAO;
import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.dto.PageCourse;
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

    /**
     * 获得分页查询信息
     * @param pageIndex 页码
     * @param pageSize 每页显示数量
     * @return 分页信息
     */
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

    /**
     * 获得课程总记录数
     * @return 课程总数
     */
    @Override
    public Integer getCourseCount() {
        return courseDAO.getCourseCount();
    }

    /**
     *获得最新课程
     * @return 最新课程
     */
    @Override
    public List<Course> getAllCourseInfo() {
        return courseDAO.getCourseByNewTime();
    }

    /**
     * 根据课程名查询课程
     * @param courseName 课程名
     * @return 课程
     */
    @Override
    public Course getCourseService(String courseName) {
        return courseDAO.getCourseByName(courseName);
    }

    /**
     * 根据课程id获得课程详细信息
     * @param courseId 课程id
     * @return 详细信息
     */
    @Override
    public CourseInfo getCourseInfoService(Integer courseId) {
        return courseDAO.getCourseInfo(courseId);
    }

    /**
     * 根据课程id获得上课时间信息
     * @param courseId 课程id
     * @return 时间信息
     */
    @Override
    public CourseInfo getCourseTime(Integer courseId) {
        return courseDAO.getCourseTime(courseId);
    }

    /**
     * 获得所有课程
     * @return 所有课程
     */
    @Override
    public List<Course> getAllCourse() {
        return courseDAO.getAllCourse();
    }


    /**
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<Course> getCourseByType(Integer pageIndex, Integer pageSize) {
        PageCourse pageCourse = new PageCourse();
        List<Course> courseList = courseDAO.getCourseByType(pageCourse);
        return courseList;
    }

    /**
     * 判断课程上课时间是否有冲突
     * @param courseFirst 课程1
     * @param courseSecond 课程2
     * @return 是否有冲突
     */
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
