package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.CourseDAO;
import com.cafebabe.phosphor.dao.SuggestDAO;
import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.dto.PageCourse;
import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.model.entity.Suggest;
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

    private final CourseDAO courseDAO;

    private final SuggestDAO suggestDAO;


    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO, SuggestDAO suggestDAO){
        this.courseDAO = courseDAO;
        this.suggestDAO = suggestDAO;
    }
    /**
     * 获得分页查询信息
     * @param pageIndex 页码
     * @param pageSize 每页显示数量
     * @return 分页信息
     */
    @Override
    public Page getAllCourseByPage(Integer pageIndex, Integer pageSize) {
        Page<Course> page = new Page<>();
        page.setTotalRecord(courseDAO.getCourseCount());
        Integer totalPages = (page.getTotalRecord() % page.getPageSize() == 0) ? (page.getTotalRecord() / page.getPageSize()) : ((page.getTotalRecord() / page.getPageSize())+1);
        page.setTotalPages(totalPages);
        page.setCurrentPageCode(pageIndex);
        page.setStartRecord(pageIndex * pageSize);
        page.setEndRecord(pageSize * (pageIndex + 1) - 1);
        List<Course> courseList = courseDAO.getCourseByPage(page);
        page.setModelList(courseList);
        return page;
    }

    @Override
    public PageCourse getCourseByType(Integer pageIndex, Integer pageSize,String orderField,Integer typeId) {
        PageCourse<Course> pageCourse = new PageCourse<>();
        String strUndefind = "undefined";
        String strNull = "null";
        if (orderField!=null && !orderField.equals(strUndefind) && !orderField.equals(strNull)){
            pageCourse.setOrderField(orderField);
        }
        if (typeId !=null){
            pageCourse.setTypeId(typeId);
        }
        pageCourse.setTotalRecord(courseDAO.getCourseCount());
        Integer totalPages = (pageCourse.getTotalRecord()%pageCourse.getPageSize()==0)?(pageCourse.getTotalRecord()/pageCourse.getPageSize()):
                ((pageCourse.getTotalRecord()/pageCourse.getPageSize())+1);
        pageCourse.setTotalPages(totalPages);
        pageCourse.setCurrentPageCode(pageIndex);
        pageCourse.setStartRecord(pageSize * pageIndex);
        pageCourse.setEndRecord(pageSize*(pageIndex+1)-1);
        List<Course> courseList = courseDAO.getCourseByType(pageCourse);
        pageCourse.setModelList(courseList);
        return pageCourse;
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


    @Override
    public CourseInfo getConflictCourseInfo(List<CourseInfo> courseInfoList, Integer courseId) {
        CourseInfo courseInfo =courseDAO.getCourseInfo(courseId);
        for (int i = 0; i < courseInfoList.size() ; i++) {
            if (courseInfoList.get(i).getCourseId().equals(courseId)){
                return courseInfoList.get(i);
            }
        }
        for (CourseInfo info : courseInfoList) {
            if (!contrastCourseTime(info,courseInfo)){
                return info;
            }
        }
        return null;
    }

    /**
     * 获得某课程所有评价
     * @param courseId 课程id
     * @return 建议列表
     */
    @Override
    public List<Suggest> getSuggestByCourse(Integer courseId) {
        return suggestDAO.getSuggestByCourse(courseId);
    }

    /**
     * 添加评价
     * @param suggest 评价
     * @return 受影响行数
     */
    @Override
    public Integer insertSuggest(Suggest suggest) {
        return suggestDAO.insertSelective(suggest);
    }

    /**
     * 判断课程上课时间是否有冲突
     * @param courseFirst 课程1
     * @param courseSecond 课程2
     * @return 是否有冲突
     */

    private boolean contrastCourseTime(CourseInfo courseFirst, CourseInfo courseSecond){
        if (!courseFirst.getCourseTimeStatus().equals(courseSecond.getCourseTimeStatus())){
            return true;
        }
        return courseFirst.getCourseStartTime() != courseSecond.getCourseEndTime();
    }
}
