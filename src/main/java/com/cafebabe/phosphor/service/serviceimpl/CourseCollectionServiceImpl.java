package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.CourseCollectionDAO;
import com.cafebabe.phosphor.model.dto.CourseCollectionInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.entity.CourseCollection;
import com.cafebabe.phosphor.service.CourseCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: CourseCollectionServiceImpl
 *
 * create_date: 2018/10/25
 *
 * create_time: 10:10
 *
 * description: 课程收藏实现类
 **/
@Service
public class CourseCollectionServiceImpl implements CourseCollectionService {


    private final CourseCollectionDAO courseCollectionDAO;

    @Autowired
    public CourseCollectionServiceImpl(CourseCollectionDAO courseCollectionDAO) {
        this.courseCollectionDAO = courseCollectionDAO;
    }


    @Override
    public List<CourseCollectionInfo> getAllCourseCollection(String parentPhone) {
        return courseCollectionDAO.getCourseCollectionByPhone(parentPhone);
    }

    @Override
    public Integer insertCollection(CourseCollection courseCollection) {
        return courseCollectionDAO.insertSelective(courseCollection);
    }

    @Override
    public Integer deleteCollection(Integer collectionId) {
        return courseCollectionDAO.deleteByPrimaryKey(collectionId);
    }
}
