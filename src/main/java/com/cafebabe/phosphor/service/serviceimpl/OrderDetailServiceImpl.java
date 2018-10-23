package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ActivityDAO;
import com.cafebabe.phosphor.dao.CourseDAO;
import com.cafebabe.phosphor.dao.GroupDAO;
import com.cafebabe.phosphor.dao.OrderDAO;
import com.cafebabe.phosphor.model.dto.OrderDetail;
import com.cafebabe.phosphor.model.entity.Activity;
import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: OrderDetailServiceImpl
 *
 * create_date: 18-10-23
 *
 * create_time: 下午2:16
 *
 * description:
 **/
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final String COURSE_PATH = "/courseUi/courseInfoUi/";
    private final String ACTIVITY_PATH ="/activityUi/returnActivityUi/";

    private final CourseDAO courseDAO;
    private final GroupDAO groupDAO;
    private final ActivityDAO activityDAO;
    @Autowired
    public OrderDetailServiceImpl(CourseDAO courseDAO, GroupDAO groupDAO, ActivityDAO activityDAO) {
        this.courseDAO = courseDAO;
        this.groupDAO = groupDAO;
        this.activityDAO = activityDAO;
    }

    @Override
    public OrderDetail getByCourseId(Integer courseId,Integer state) {

        return null;
    }

    @Override
    public OrderDetail getByActivityId(Integer activityId,Integer state) {
        return null;
    }

    @Override
    public List<OrderDetail> getListByCourseId(Integer courseId, Integer state) {
        return null;
    }

    @Override
    public List<OrderDetail> getListByActivityId(Integer activityId, Integer state) {
        return null;
    }

    @Override
    public List<OrderDetail> getListByGroupId(Integer groupId) {
        return null;
    }

    /**
     * 课程转化为orderDetail
     * @param course 课程
     * @param state 状态
     * @return 订单详情
     */
    /*private OrderDetail courseToDetail( Course course,Integer state){
        return new OrderDetail(course.getCourseId(),
                course.getCourseName(),
                course.getCourseDesc(),
                "/upload/people.jpg",
                state,
                course.getCoursePrice(),
                "课程");
    }

    private OrderDetail activityToDetail(Activity activity,Integer state){
        return new OrderDetail(activity.getActivityId(),
                activity.getActivityTitle(),
                activity.getActivityDesc(),
                "/upload/people.jpg",
                state,
                activity.getActivityPrice(),
                "活动");
    }*/
}
