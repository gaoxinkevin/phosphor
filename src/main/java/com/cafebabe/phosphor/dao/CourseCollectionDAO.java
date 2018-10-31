package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.dto.CourseCollectionInfo;
import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.entity.CourseCollection;

import java.util.List;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: CourseCollectionDAO
 *
 * create_date: 2018/10/25
 *
 * create_time: 9:50
 *
 * description: 课程收藏接口
 **/
public interface CourseCollectionDAO extends MyBatisBaseDao<CourseCollection, Integer> {

    /**
     * 根据用户id查询课程收藏
     * @return 收藏的课程
     */
    List<CourseCollectionInfo> getCourseCollectionByParentId(Page page,Integer parentId);

    /**
     * 获得某用户收藏总记录数
     * @return 收藏数量
     */
    Integer getCourseCollectionCount(Integer parentId);

}