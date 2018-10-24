package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.*;
import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.OrderDetail;
import com.cafebabe.phosphor.model.entity.Activity;
import com.cafebabe.phosphor.model.entity.GroupCourse;
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


    private final CourseDAO courseDAO;
    private final GroupDAO groupDAO;
    private final ActivityDAO activityDAO;
    private final GroupCourseDAO groupCourseDAO;
    @Autowired
    public OrderDetailServiceImpl(CourseDAO courseDAO, GroupDAO groupDAO, ActivityDAO activityDAO,GroupCourseDAO groupCourseDAO) {
        this.courseDAO = courseDAO;
        this.groupDAO = groupDAO;
        this.activityDAO = activityDAO;
        this.groupCourseDAO = groupCourseDAO;
    }

    @Override
    public OrderDetail getByCourseId(Integer courseId,Integer state) {

        CourseInfo course = courseDAO.getCourseInfo(courseId);
        if (course == null) {
            return null;
        }
        return courseToDetail(course,state);
    }

    @Override
    public OrderDetail getByActivityId(Integer activityId,Integer state) {

        Activity activity = activityDAO.getActivityByID(activityId);
        if (activity == null) {
            return null;
        }
        return activityToDetail(activity,state);
    }

    @Override
    public List<OrderDetail> getListByCourseId(Integer courseId, Integer state) {

        CourseInfo course = courseDAO.getCourseInfo(courseId);
        if (course == null) {
            return null;
        }
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(courseToDetail(course,state));
        return orderDetails;
    }

    @Override
    public List<OrderDetail> getListByActivityId(Integer activityId, Integer state) {

        Activity activity = activityDAO.getActivityByID(activityId);
        if (activity == null) {
            return null;
        }
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(activityToDetail(activity,state));
        return orderDetails;
    }

    @Override
    public List<OrderDetail> getListByGroupId(Integer groupId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        List<GroupCourse> groupCourses = groupCourseDAO.getGroupCourse(groupId);
        for (GroupCourse groupCourse: groupCourses) {
            CourseInfo course = courseDAO.getCourseInfo(groupCourse.getCourseId());
            if (course == null) {
                return null;
            }
            orderDetails.add(courseToDetail(course,Integer.parseInt(groupCourse.getGroupCourseSf())));
        }
        return orderDetails;
    }

    /**
     * 课程转化为orderDetail
     * @param course 课程
     * @param state 状态
     * @return 订单详情
     */
    private OrderDetail courseToDetail(CourseInfo course,Integer state){
        return new OrderDetail(course.getCourseId(),
                course.getCourseName(),
                course.getCourseDesc(),
                "/upload/people.jpg",
                state,
                course.getCoursePrice(),
                course.getCompanyName(),
                10001,
                "课程");
    }

    private OrderDetail activityToDetail(Activity activity, Integer state){
        return new OrderDetail(activity.getActivityId(),
                activity.getActivityTitle(),
                activity.getActivityDesc(),
                "/upload/people.jpg",
                state,
                activity.getActivityPrice(),
                activity.getCompanyName(),
                activity.getCompanyId(),
                "活动");
    }
}
