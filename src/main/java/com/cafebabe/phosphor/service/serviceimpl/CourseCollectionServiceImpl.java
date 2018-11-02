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
    public Page getAllCourseCollection(Integer pageIndex, Integer pageSize, Integer parentId) {
        Page<CourseCollectionInfo> page = new Page<>();
        page.setPageSize(3);
        page.setTotalRecord(courseCollectionDAO.getCourseCollectionCount(parentId));
        Integer totalPages = (page.getTotalRecord() % page.getPageSize() == 0) ? (page.getTotalRecord() / page.getPageSize()) : ((page.getTotalRecord() / page.getPageSize())+1);
        page.setTotalPages(totalPages);
        page.setCurrentPageCode(pageIndex);
        page.setStartRecord(pageIndex * pageSize);
        page.setEndRecord(pageSize * (pageIndex + 1) - 1);
        List<CourseCollectionInfo> courseCollectionInfoList = courseCollectionDAO.getCourseCollectionByParentId(page,parentId);
        page.setModelList(courseCollectionInfoList);
        return page;
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
